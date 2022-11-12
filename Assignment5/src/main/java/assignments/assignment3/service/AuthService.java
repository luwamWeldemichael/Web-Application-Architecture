package assignments.assignment3.service;

import assignments.assignment3.domain.dto.request.LoginRequest;
import assignments.assignment3.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

}
