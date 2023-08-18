package dammy.example.authentication.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("AuthUser")
public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
