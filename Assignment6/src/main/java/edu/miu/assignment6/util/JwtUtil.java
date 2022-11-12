package edu.miu.assignment6.util;

import java.util.Date;

import edu.miu.assignment6.service.imp.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

    @Component
    public class JwtUtil {
        private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

        @Value("${spring.security.jwt.secret.access_token}")
        private String access_secret;

        @Value("${spring.security.jwt.access_expiration_ms}")
        private long access_expiration;

        @Value("${spring.security.jwt.secret.refresh_token}")
        private String refresh_secret;

        @Value("${spring.security.jwt.refresh_expiration_ms}")
        private long refresh_expiration;

        public String generateJwtAccessToken(UserDetails userPrincipal) {
            return generateAccessTokenFromUsername(userPrincipal.getUsername());
        }

        public String generateAccessTokenFromUsername(String username) {
            return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + access_expiration)).signWith(SignatureAlgorithm.HS512, access_secret)
                    .compact();
        }

        public String generateRefreshTokenFromUsername(String username) {
            return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + refresh_expiration)).signWith(SignatureAlgorithm.HS512, refresh_secret)
                    .compact();
        }

        public String getUserNameFromJwtAccessToken(String token) {
            return Jwts.parser().setSigningKey(access_secret).parseClaimsJws(token).getBody().getSubject();
        }

        public boolean validateJwtAccessToken(String authToken) {
            try {
                Jwts.parser().setSigningKey(access_secret).parseClaimsJws(authToken);
                return true;
            } catch (SignatureException e) {
                logger.error("Invalid JWT signature: {}", e.getMessage());
            } catch (MalformedJwtException e) {
                logger.error("Invalid JWT token: {}", e.getMessage());
            } catch (ExpiredJwtException e) {
                logger.error("JWT token is expired: {}", e.getMessage());
            } catch (UnsupportedJwtException e) {
                logger.error("JWT token is unsupported: {}", e.getMessage());
            } catch (IllegalArgumentException e) {
                logger.error("JWT claims string is empty: {}", e.getMessage());
            }

            return false;
        }

    }