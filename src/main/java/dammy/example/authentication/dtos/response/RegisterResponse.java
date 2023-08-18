package dammy.example.authentication.dtos.response;

import lombok.Data;

@Data
public class RegisterResponse {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String message;
}
