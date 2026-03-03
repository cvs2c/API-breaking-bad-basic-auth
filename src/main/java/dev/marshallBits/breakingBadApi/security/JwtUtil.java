package dev.marshallBits.breakingBadApi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
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

    public DecodedJWT validateToken(String token){
        try{
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token);
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    public String getUsernameFromToken(String token){
        DecodedJWT decodedJwt = validateToken(token);
        return decodedJwt != null ? decodedJwt.getSubject() : null;
    }

    public String getRoleFromToken(String token){
        DecodedJWT decodedJwt = validateToken(token);
        return decodedJwt != null ? decodedJwt.getClaim("role").asString() : null;
    }


}
