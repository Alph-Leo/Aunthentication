package dammy.example.authentication.service;

import dammy.example.authentication.data.repositories.UserRepository;
import dammy.example.authentication.dtos.request.LoginRequest;
import dammy.example.authentication.dtos.request.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void signUp() {

    var request = createRegistrationRequesr();
        userService.signUp(request);
        log.info("Newly Registered User------->{}", request);
        assertNotNull(request);

    }
    private  RegisterRequest createRegistrationRequesr(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Batman");
        request.setLastName("John");
        request.setPhoneNumber("07065506982");
        request.setEmail("batmane@ymail.com");
        request.setPassword("batmaning123@");
        return request;
    }

    @Test
    void login() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Chen");
        request.setLastName("Fu");
        request.setPhoneNumber("+1836453994776");
        request.setEmail("dammoh@yahoo.com");
        request.setPassword("lionheart");

        userService.signUp(request);
        log.info("Newly Registered User------->{}", request);
        assertNotNull(request);


        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(request.getEmail());
        loginRequest.setPassword(request.getPassword());


        userService.login(loginRequest);

        assertNotNull(loginRequest);

    }
}