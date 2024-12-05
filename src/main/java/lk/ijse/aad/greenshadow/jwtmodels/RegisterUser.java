package lk.ijse.aad.greenshadow.jwtmodels;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterUser {
    private String email;
    private String password;
}
