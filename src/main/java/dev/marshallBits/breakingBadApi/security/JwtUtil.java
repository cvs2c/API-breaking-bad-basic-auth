package dev.marshallBits.breakingBadApi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expireDate;

    //Metodo para generar un token
    public String generateTocken(String username, String role){
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withExpiresAt(new Date(System.currentTimeMillis() + expireDate))
                .sign(Algorithm.HMAC256(secret));
    }
}
