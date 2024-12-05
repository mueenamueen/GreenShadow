package lk.ijse.aad.greenshadow.service.impl;

import lk.ijse.aad.greenshadow.repository.VehicleRepository;
import lk.ijse.aad.greenshadow.dto.VehicleDTO;
import lk.ijse.aad.greenshadow.entity.Vehicle;
import lk.ijse.aad.greenshadow.exception.DataPersistFailedException;
import lk.ijse.aad.greenshadow.exception.VehicleNotFoundException;
import lk.ijse.aad.greenshadow.response.impl.VehicleErrorResponse;
import lk.ijse.aad.greenshadow.response.VehicleResponse;
import lk.ijse.aad.greenshadow.service.VehicleService;
import lk.ijse.aad.greenshadow.util.AppUtil;
import lk.ijse.aad.greenshadow.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final Mapping mapping;
    private final VehicleRepository vehicleRepository;
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDTO.setVehicleCode(AppUtil.generateId("VEH"));
        Vehicle saved = vehicleRepository.save(mapping.map(vehicleDTO, Vehicle.class));
        if (saved.getVehicleCode() == null){
            throw new DataPersistFailedException("Failed to save vehicle data!");
        }
    }

    @Override
    public void deleteVehicle(String vehicleCode){
        Optional<Vehicle> vehicleOptById = vehicleRepository.findById(vehicleCode);
        if (vehicleOptById.isEmpty()){
            throw new VehicleNotFoundException("Vehicle not found");
        } else {
            vehicleRepository.deleteById(vehicleCode);
        }
    }

    @Override
    public void updateVehicle(String vehicleCode, VehicleDTO vehicle) {
        vehicleRepository.findById(vehicleCode).ifPresentOrElse(
                selectedVehicle -> {
                    vehicle.setVehicleCode(selectedVehicle.getVehicleCode());
                    vehicleRepository.save(mapping.map(vehicle, Vehicle.class));
                }, () -> {
                    throw new VehicleNotFoundException("Vehicle not found");
                }
        );
    }

    @Override
    public VehicleResponse getSelectedVehicle(String vehicleCode) {
        if (vehicleRepository.existsById(vehicleCode)){
            return mapping.map(vehicleRepository.getById(vehicleCode), VehicleDTO.class);
        } else {
            return new VehicleErrorResponse(404, "Vehicle not found");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapping.mapList(vehicleRepository.findAll(), VehicleDTO.class);
    }

}
