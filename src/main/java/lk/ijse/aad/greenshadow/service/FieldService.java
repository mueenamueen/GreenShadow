package lk.ijse.aad.greenshadow.service;

import jakarta.validation.Valid;
import lk.ijse.aad.greenshadow.dto.FieldDTO;
import lk.ijse.aad.greenshadow.response.FieldResponse;

import java.util.List;

public interface FieldService {
    void saveField(@Valid FieldDTO field);
    void deleteField(String fieldCode);
    void updateField(String fieldCode, FieldDTO fieldDTO);
    FieldResponse getSelectedField(String fieldCode);
    List<FieldDTO> getAllFields();
}
