package lk.ijse.aad.greenshadow.response.impl;

import lk.ijse.aad.greenshadow.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserErrorResponse implements UserResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
