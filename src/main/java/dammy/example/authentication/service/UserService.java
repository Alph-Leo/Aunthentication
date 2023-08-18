package dammy.example.authentication.service;

import dammy.example.authentication.dtos.request.LoginRequest;
import dammy.example.authentication.dtos.request.RegisterRequest;
import dammy.example.authentication.dtos.response.LoginResponse;
import dammy.example.authentication.dtos.response.RegisterResponse;

public interface UserService {
    RegisterResponse signUp(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
