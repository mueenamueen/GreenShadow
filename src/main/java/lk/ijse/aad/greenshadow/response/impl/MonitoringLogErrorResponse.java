package lk.ijse.aad.greenshadow.response.impl;

import lk.ijse.aad.greenshadow.response.MonitoringLogResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogErrorResponse implements MonitoringLogResponse {
    private int errorCode;
    private String errorMessage;
}
