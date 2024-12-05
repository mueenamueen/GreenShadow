package lk.ijse.aad.greenshadow.service;

import lk.ijse.aad.greenshadow.dto.MonitoringLogDTO;
import lk.ijse.aad.greenshadow.response.MonitoringLogResponse;

import java.util.List;

public interface MonitoringLogService {
    void saveMonitoringLog(MonitoringLogDTO monitoringLogDTO);
    void deleteMonitoringLog(String logCode);
    void updateMonitoringLog(String logCode, MonitoringLogDTO monitoringLogDTO);
    MonitoringLogResponse getSelectedMonitoringLog(String logCode);
    List<MonitoringLogDTO> getAllMonitoringLogs();
}
