package com.vti.group1.shopapi.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vti.group1.shopapi.repository.TokenRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtService {

    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Value("${jwt.secret}")
    private String secret;

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String username) {
        return JWT.create().withIssuer(username).withIssuedAt(new Date()).withExpiresAt(new Date(
                System.currentTimeMillis() + 2 * 60 * 60 * 1000)).sign(Algorithm.HMAC256(secret));
    }

    public UsernamePasswordAuthenticationToken createAuthentication(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getIssuer();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(username, null,
                userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();

        DecodedJWT decodedJWT = verifier.verify(token);
        Date expirationDate = decodedJWT.getExpiresAt();
        return expirationDate.after(new Date()) && tokenRepository.existsByToken(token);
    }
}
