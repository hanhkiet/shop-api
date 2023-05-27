package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.service.CustomerAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/auth")
@RequiredArgsConstructor
public class CustomerAuthenticationController {

    private final CustomerAuthService customerAuthService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestHeader("username") String username,
            @RequestHeader("password") String password) {

        customerAuthService.register(username, password);
        return ResponseEntity.ok("Register successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestHeader("username") String username,
            @RequestHeader("password") String password) {
        return ResponseEntity.ok("Login successfully!");
    }
}
