package com.smartfisherman.smartfishermansystem.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET =
            "smartfishermansecretkeysmartfishermansecretkey123456789";

    private final SecretKey secretKey =
            Keys.hmacShaKeyFor(SECRET.getBytes());


    public String generateToken(String email){

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                + 1000 * 60 * 60 * 24
                        )
                )
                .signWith(secretKey)
                .compact();
    }


    public String extractEmail(String token){

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }
    public boolean isTokenValid(String token){

    try{

        Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);

        return true;

    }catch (Exception e){

        return false;

    }
}
}