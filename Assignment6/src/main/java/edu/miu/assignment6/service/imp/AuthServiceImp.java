package edu.miu.assignment6.service.imp;

import edu.miu.assignment6.entity.RefreshToken;
import edu.miu.assignment6.entity.dto.request.LoginRequest;
import edu.miu.assignment6.entity.dto.response.LoginResponse;
import edu.miu.assignment6.entity.dto.response.RefreshTokenResponse;
import edu.miu.assignment6.exception.RefreshTokenException;
import edu.miu.assignment6.service.AuthService;
import edu.miu.assignment6.service.RefreshTokenService;
import edu.miu.assignment6.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImp implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    private final RefreshTokenService refreshTokenService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getEmail());

        final String accessToken = jwtUtil.generateAccessTokenFromUsername(loginRequest.getEmail());
        final String refreshToken = refreshTokenService.createRefreshTokenByEmail(loginRequest.getEmail()).getToken();
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public ResponseEntity<?> refreshToken(String requestRefreshToken) {
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    final String accessToken = jwtUtil.generateAccessTokenFromUsername(user.getEmail());
                    return ResponseEntity.ok(new RefreshTokenResponse(accessToken, requestRefreshToken));
                })
                .orElseThrow(() -> new RefreshTokenException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }
}
