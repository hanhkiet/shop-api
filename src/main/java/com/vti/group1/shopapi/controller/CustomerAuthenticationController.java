package com.vti.group1.shopapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.dto.RegisterDto;
import com.vti.group1.shopapi.dto.UserDto;
import com.vti.group1.shopapi.service.CustomerAuthService;
import com.vti.group1.shopapi.service.JwtService;
import com.vti.group1.shopapi.service.TokenService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customer/auth")
@Transactional
@RequiredArgsConstructor
public class CustomerAuthenticationController {

    private final CustomerAuthService customerAuthService;
    private final JwtService jwtService;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(
            @RequestBody CredentialsDto credentialsDto) {
        UserDto userDto = customerAuthService.login(credentialsDto);
        String token = jwtService.createToken(userDto.getUsername());
        HttpHeaders headers = createHeadersWithCookie(token);
        tokenService.saveToken(userDto.getUsername(), token);

        return ResponseEntity.ok().headers(headers).body(userDto);
    }

    private HttpHeaders createHeadersWithCookie(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE,
                "customerJwt=" + token + "; Path=/; HttpOnly; " + "SameSite=None; Secure");

        return headers;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(
            @RequestBody RegisterDto registerDto) {
        UserDto userDto = customerAuthService.register(registerDto);
        String token = jwtService.createToken(userDto.getUsername());
        HttpHeaders headers = createHeadersWithCookie(token);
        tokenService.saveToken(userDto.getUsername(), token);

        return ResponseEntity.ok().headers(headers).body(userDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            @AuthenticationPrincipal String name) {
        customerAuthService.logout(name);
        return ResponseEntity.ok().body("Logout successfully");
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(
            @AuthenticationPrincipal String name) {
        String token = jwtService.createToken(name);
        HttpHeaders headers = createHeadersWithCookie(token);
        tokenService.saveToken(name, token);

        return ResponseEntity.ok().headers(headers).body("Refresh token successfully");
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @AuthenticationPrincipal String name, @RequestBody CredentialsDto credentialsDto) {
        customerAuthService.changePassword(name, credentialsDto);
        return ResponseEntity.ok().body("Change password successfully");
    }
}
