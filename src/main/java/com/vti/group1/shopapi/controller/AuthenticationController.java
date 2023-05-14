package com.vti.group1.shopapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.model.LoginRequest;
import com.vti.group1.shopapi.model.LoginResponse;
import com.vti.group1.shopapi.model.LogoutResponse;
import com.vti.group1.shopapi.model.RegisterRequest;
import com.vti.group1.shopapi.model.RegisterResponse;
import com.vti.group1.shopapi.services.AuthenticationService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request) {
        RegisterResponse response = authenticationService.register(request);
        String jwt = response.getJwt();

        Cookie cookie = new Cookie("token", jwt);
        cookie.setMaxAge(10);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(response);
    }

    // @GetMapping("/validate")
    // public ResponseEntity<JwtResponse> validate(HttpServletRequest request) {
    // JwtResponse response = authenticationService.validate(request);
    // }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {
        LoginResponse response = authenticationService.login(request);
        String jwt = response.getJwt();

        Cookie cookie = new Cookie("token", jwt);
        cookie.setMaxAge(10);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(HttpServletRequest request) {
        LogoutResponse response = authenticationService.logout(request);
        return ResponseEntity.ok().body(response);
    }
}
