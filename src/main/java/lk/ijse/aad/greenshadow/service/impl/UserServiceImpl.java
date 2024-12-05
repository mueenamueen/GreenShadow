package lk.ijse.aad.greenshadow.service.impl;

import lk.ijse.aad.greenshadow.repository.UserRepository;
import lk.ijse.aad.greenshadow.dto.UserDTO;
import lk.ijse.aad.greenshadow.entity.User;
import lk.ijse.aad.greenshadow.exception.DataPersistFailedException;
import lk.ijse.aad.greenshadow.exception.UserNotFoundException;
import lk.ijse.aad.greenshadow.response.UserResponse;
import lk.ijse.aad.greenshadow.response.impl.UserErrorResponse;
import lk.ijse.aad.greenshadow.service.UserService;
import lk.ijse.aad.greenshadow.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final Mapping mapping;
    private final UserRepository userRepository;
    // set encoder strength to 12 to make it more secure
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Override
    public void addUser(UserDTO userDTO) {
//        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        User saved = userRepository.save(mapping.map(userDTO, User.class));
        if (saved.getEmail() == null){
            throw new DataPersistFailedException("Failed to save the user");
        }
    }

    @Override
    public void removeUser(String email) {
        Optional<User> userOptByMail = userRepository.findById(email);
        if (userOptByMail.isEmpty()){
            throw new UserNotFoundException("User not found");
        } else {
            userRepository.deleteById(email);
        }
    }

    @Override
    public void updateUser(String email, UserDTO userDTO) {
        userRepository.findById(email).ifPresentOrElse(selectedUser -> {
            userDTO.setEmail(selectedUser.getEmail());
            userRepository.save(mapping.map(userDTO, User.class));
        }, () -> {
            throw new UserNotFoundException("User not found");
        });
    }

    @Override
    public UserResponse getUser(String email) {
       if (userRepository.existsById(email)){
           return mapping.map(userRepository.findById(email), UserDTO.class);
       } else {
           return new UserErrorResponse(404, "User not found");
       }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.mapList(userRepository.findAll(), UserDTO.class);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return email -> {
            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException("User not found"));
        };
    }



}
