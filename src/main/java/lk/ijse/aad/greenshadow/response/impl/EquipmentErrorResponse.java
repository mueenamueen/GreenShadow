package lk.ijse.aad.greenshadow.response.impl;

import lk.ijse.aad.greenshadow.response.EquipmentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentErrorResponse implements EquipmentResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
