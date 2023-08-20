package dammy.example.authentication.controller;

import dammy.example.authentication.dtos.request.ForgotPasswordRequest;
import dammy.example.authentication.dtos.request.LoginRequest;
import dammy.example.authentication.dtos.request.RegisterRequest;
import dammy.example.authentication.dtos.response.ForgotPasswordResponse;
import dammy.example.authentication.dtos.response.LoginResponse;
import dammy.example.authentication.dtos.response.RegisterResponse;
import dammy.example.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authUser")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<RegisterResponse> signUp(@RequestBody RegisterRequest registerRequest){
        var response = userService.signUp(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        var response = userService.login(loginRequest);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/forgotPassword")
    public ResponseEntity<ForgotPasswordResponse> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest){
        var response = userService.forgotPassword(forgotPasswordRequest);
        return ResponseEntity.ok().body(response);
    }
}
