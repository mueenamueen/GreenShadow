package lk.ijse.aad.greenshadow.service;

import lk.ijse.aad.greenshadow.dto.StaffDTO;
import lk.ijse.aad.greenshadow.response.StaffResponse;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO) throws Exception;
    void deleteStaff(String staffId);
    void updateStaff(String staffId, StaffDTO staff);
    StaffResponse getSelectedStaff(String staffId);
    List<StaffDTO> getAllStaff();
}
