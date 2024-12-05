package lk.ijse.aad.greenshadow.response.impl;

import lk.ijse.aad.greenshadow.response.FieldResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldErrorResponse implements FieldResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
