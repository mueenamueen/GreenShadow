package lk.ijse.aad.greenshadow.service;

import lk.ijse.aad.greenshadow.dto.VehicleDTO;
import lk.ijse.aad.greenshadow.response.VehicleResponse;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicleCode);
    void updateVehicle(String vehicleCode, VehicleDTO vehicle);
    VehicleResponse getSelectedVehicle(String vehicleCode);
    List<VehicleDTO> getAllVehicles();
}
