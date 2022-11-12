package edu.miu.assignment6.service.imp;

import edu.miu.assignment6.entity.RefreshToken;
import edu.miu.assignment6.exception.RefreshTokenException;
import edu.miu.assignment6.repo.RefreshTokenRepo;
import edu.miu.assignment6.repo.UserRepo;
import edu.miu.assignment6.service.RefreshTokenService;
import edu.miu.assignment6.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {
    @Value("${spring.security.jwt.refresh_expiration_ms}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepo refreshTokenRepo;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepo.findByToken(token);
    }


    @Override
    public RefreshToken createRefreshTokenByEmail(String email) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userRepo.findByEmail(email));
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(jwtUtil.generateRefreshTokenFromUsername(email));
        refreshToken = refreshTokenRepo.save(refreshToken);
        return refreshToken;
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepo.delete(token);
            throw new RefreshTokenException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

    @Override
    public int deleteByUserId(Long userId) {
        return refreshTokenRepo.deleteByUser(userRepo.findById(userId).get());
    }
}
