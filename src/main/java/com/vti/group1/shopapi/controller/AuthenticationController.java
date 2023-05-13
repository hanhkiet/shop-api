package com.vti.group1.shopapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.model.AuthenticationResponse;
import com.vti.group1.shopapi.model.JwtResponse;
import com.vti.group1.shopapi.model.LoginRequest;
import com.vti.group1.shopapi.model.LogoutResponse;
import com.vti.group1.shopapi.model.RegisterRequest;
import com.vti.group1.shopapi.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        AuthenticationResponse response = authenticationService.register(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validate")
    public ResponseEntity<JwtResponse> validate(HttpServletRequest request) {
        String token = authenticationService.validate(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, "token=" + token + "; HttpOnly; SameSite=None; Secure");
        JwtResponse response = JwtResponse.builder().build();
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request) {
        return ResponseEntity
                .ok(authenticationService.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(HttpServletRequest request) {
        LogoutResponse response = authenticationService.logout(request);
        return ResponseEntity.ok(response);
    }
}
