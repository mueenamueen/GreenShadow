package lk.ijse.aad.greenshadow.service;

import jakarta.validation.Valid;
import lk.ijse.aad.greenshadow.dto.EquipmentDTO;
import lk.ijse.aad.greenshadow.response.EquipmentResponse;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(@Valid EquipmentDTO equipment);
    void deleteEquipment(String equipmentId);
    void updateEquipment(String equipmentId, @Valid EquipmentDTO equipment);
    EquipmentResponse getSelectedEquipment(String equipmentId);
    List<EquipmentDTO> getAllEquipments();
}
