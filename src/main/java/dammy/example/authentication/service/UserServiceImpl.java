package dammy.example.authentication.service;

import dammy.example.authentication.data.models.User;
import dammy.example.authentication.data.repositories.UserRepository;
import dammy.example.authentication.dtos.request.ForgotPasswordRequest;
import dammy.example.authentication.dtos.request.LoginRequest;
import dammy.example.authentication.dtos.request.RegisterRequest;
import dammy.example.authentication.dtos.response.ForgotPasswordResponse;
import dammy.example.authentication.dtos.response.LoginResponse;
import dammy.example.authentication.dtos.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public RegisterResponse signUp(RegisterRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());

        User newUser = userRepository.save(user);
        log.info("New User------>{}", newUser);

        return getRegisterResponse(newUser);
    }

    private static RegisterResponse getRegisterResponse(User newUser) {
        RegisterResponse response = new RegisterResponse();
        response.setFirstName(newUser.getFirstName());
        response.setLastName(newUser.getLastName());
        response.setPhoneNumber(newUser.getPhoneNumber());
        response.setEmail(newUser.getEmail());
        response.setMessage("New User Successfully Registered");

        return response;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<User> foundUser = userRepository.findByEmail(email);
        User user = foundUser.orElseThrow(()-> new IllegalArgumentException("User Not Found"));

        boolean validPassword = isMatch(user.getPassword(), password);
        if (validPassword){
            log.info(email);
            loginResponse.setMessage("login successful");
            loginResponse.setEmail(email);

            return loginResponse;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }

    @Override
    public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        String email = forgotPasswordRequest.getEmail();
        Optional<User> foundUser = userRepository.findByEmail(email);
        if (foundUser.isPresent()){
            User user = foundUser.get();

            String newPassword = generatePassword();
             user.setPassword(encodePassword(newPassword));
             userRepository.save(user);
             ForgotPasswordResponse response = new ForgotPasswordResponse();
             response.setMessage("Password reset successfully");
            log.info("User with new Password------->{}", user);
            return response;

        }
        throw  new IllegalArgumentException("User with provided email not found");
    }

    private static boolean isMatch(String a, String b){
        return a.equals(b);
    }
    private static String generatePassword(){
        return "saint9danchrysalisrealm";
    }
    private String encodePassword(String password){
        return password;
    }
}
