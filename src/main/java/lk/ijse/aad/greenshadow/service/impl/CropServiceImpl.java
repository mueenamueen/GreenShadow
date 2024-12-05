package lk.ijse.aad.greenshadow.service.impl;

import lk.ijse.aad.greenshadow.repository.CropRepository;
import lk.ijse.aad.greenshadow.dto.CropDTO;
import lk.ijse.aad.greenshadow.entity.Crop;
import lk.ijse.aad.greenshadow.exception.CropNotFoundException;
import lk.ijse.aad.greenshadow.exception.DataPersistFailedException;
import lk.ijse.aad.greenshadow.response.impl.CropErrorResponse;
import lk.ijse.aad.greenshadow.response.CropResponse;
import lk.ijse.aad.greenshadow.service.CropService;
import lk.ijse.aad.greenshadow.util.AppUtil;
import lk.ijse.aad.greenshadow.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {
    private final CropRepository cropRepository;
    private final Mapping mapping;
    @Override
    public void saveCrop(CropDTO cropDTO) {
        cropDTO.setCropCode(AppUtil.generateId("CR"));
        Crop saved = cropRepository.save(mapping.map(cropDTO, Crop.class));
        if (saved.getCropCode() == null){
            throw new DataPersistFailedException("Failed to save crop data");
        }
    }

    @Override
    public void deleteCrop(String cropCode) {
        Optional<Crop> cropOptById = cropRepository.findById(cropCode);
        if (cropOptById.isEmpty()){
            throw new CropNotFoundException("Crop not found");
        } else {
            cropRepository.deleteById(cropCode);
        }
    }

    @Override
    public void updateCrop(String cropCode, CropDTO cropDTO) {
        cropRepository.findById(cropCode).ifPresentOrElse(
                selectedCrop -> {
                    cropDTO.setCropCode(selectedCrop.getCropCode());
                    cropRepository.save(mapping.map(cropDTO, Crop.class));
                }, () -> {
                    throw new CropNotFoundException("Crop not found");
                }
        );
    }

    @Override
    public CropResponse getSelectedCrop(String cropCode) {
        if (cropRepository.existsById(cropCode)){
            return mapping.map(cropRepository.getById(cropCode), CropDTO.class);
        } else {
            return new CropErrorResponse(404, "Crop not found");

        }
    }

    @Override
    public List<CropDTO> getAllCrops() {
        return mapping.mapList(cropRepository.findAll(), CropDTO.class);
    }
}
