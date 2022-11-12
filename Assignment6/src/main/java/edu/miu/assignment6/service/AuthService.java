package edu.miu.assignment6.service;

import edu.miu.assignment6.entity.dto.request.LoginRequest;
import edu.miu.assignment6.entity.dto.response.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    ResponseEntity<?> refreshToken(String requestRefreshToken);
}
