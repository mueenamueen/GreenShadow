package lk.ijse.aad.greenshadow.service;

import jakarta.validation.Valid;
import lk.ijse.aad.greenshadow.dto.UserDTO;
import lk.ijse.aad.greenshadow.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    void addUser(@Valid UserDTO userDTO);
    void removeUser(String email);
    void updateUser(String email, UserDTO userDTO);
    UserResponse getUser(String email);
    List<UserDTO> getAllUsers();

    UserDetailsService userDetailsService();
}
