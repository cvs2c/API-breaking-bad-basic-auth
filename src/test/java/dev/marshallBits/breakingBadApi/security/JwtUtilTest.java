package dev.marshallBits.breakingBadApi.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JwtUtilTest {
    @Autowired
    JwtUtil jwtUtil;

    @Test
    public void generateTocken() {
        String token = jwtUtil.generateTocken("eduardo", "ROLE_USER");

        System.out.println(token);
        assertNotNull(token);

    }

}
