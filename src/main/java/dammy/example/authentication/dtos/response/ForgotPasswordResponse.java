package dammy.example.authentication.dtos.response;

import lombok.Data;

@Data
public class ForgotPasswordResponse {
    private String password;
    private String message;
}
