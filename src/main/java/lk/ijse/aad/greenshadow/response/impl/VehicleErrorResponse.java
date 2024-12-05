package lk.ijse.aad.greenshadow.response.impl;

import lk.ijse.aad.greenshadow.response.VehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleErrorResponse implements VehicleResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
