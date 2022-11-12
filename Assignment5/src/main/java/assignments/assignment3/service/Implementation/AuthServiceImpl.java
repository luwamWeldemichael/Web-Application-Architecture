package assignments.assignment3.service.Implementation;

import assignments.assignment3.Util.JwtUtil;
import assignments.assignment3.domain.dto.request.LoginRequest;
import assignments.assignment3.domain.dto.response.LoginResponse;
import assignments.assignment3.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

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

        final String accessToken = jwtUtil.generateToken(userDetails);
        var loginResponse = new LoginResponse(accessToken);
        return loginResponse;
    }
}

