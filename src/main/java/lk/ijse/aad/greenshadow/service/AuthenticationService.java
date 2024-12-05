package lk.ijse.aad.greenshadow.service;

import lk.ijse.aad.greenshadow.exception.InvalidCredentialsException;
import lk.ijse.aad.greenshadow.jwtmodels.AuthResponse;
import lk.ijse.aad.greenshadow.jwtmodels.RegisterUser;
import lk.ijse.aad.greenshadow.jwtmodels.UserLogin;

public interface AuthenticationService {
    AuthResponse registerUser(RegisterUser user);
    AuthResponse login(UserLogin login) throws InvalidCredentialsException;
    AuthResponse refreshToken(String refreshToken);
}
