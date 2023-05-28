package com.vti.group1.shopapi.config;

import com.vti.group1.shopapi.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String jwt = extractTokenFromRequest(request);
        LOGGER.info("JWT: {}", jwt);

        if (jwt != null && jwtService.validateToken(jwt)) createAuthenticationForCustomer(jwt);

        filterChain.doFilter(request, response);
    }

    private void createAuthenticationForCustomer(String jwt) {
        try {
            UsernamePasswordAuthenticationToken authentication =
                    jwtService.createAuthentication(jwt);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LOGGER.info("Authentication: {}", authentication);
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
            throw e;
        }
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("managerJwt")) {
                return cookie.getValue();
            }
        }

        return null;
    }

    @Override
    public boolean shouldNotFilter(HttpServletRequest request) {
        return request.getServletPath().startsWith("/api/manager/auth");
    }
}
