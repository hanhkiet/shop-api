package com.vti.group1.shopapi.services;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.entity.InvalidToken;
import com.vti.group1.shopapi.repository.InvalidTokenRepository;
import com.vti.group1.shopapi.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService implements LogoutSuccessHandler {

    private final InvalidTokenRepository invalidTokenRepository;

    public String extractUserEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(JwtUtil.SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(Map.of(), userDetails);
    }

    public String generateToken(
            Map<String, Object> claims,
            UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JwtUtil.EXPIRATION_TIME))
                .signWith(JwtUtil.SECRET_KEY)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {

        final String email = extractUserEmail(token);
        return email.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean isTokenGotBlacklisted(String token) {
        return invalidTokenRepository.findById(token).isPresent();
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        clearAuthentication(request);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void clearAuthentication(HttpServletRequest request) {
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        invalidateToken(request);
    }

    private void invalidateToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        var invalidToken = new InvalidToken(token);

        invalidTokenRepository.save(invalidToken);
    }
}
