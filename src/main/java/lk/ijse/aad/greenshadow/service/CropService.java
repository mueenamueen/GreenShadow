package lk.ijse.aad.greenshadow.service;

import jakarta.validation.Valid;
import lk.ijse.aad.greenshadow.dto.CropDTO;
import lk.ijse.aad.greenshadow.response.CropResponse;

import java.util.List;


public interface CropService {
    void saveCrop(@Valid CropDTO cropDTO);
    void deleteCrop(String cropCode);
    void updateCrop(String cropCode, CropDTO cropDTO);
    CropResponse getSelectedCrop(String cropCode);
    List<CropDTO> getAllCrops();
}
