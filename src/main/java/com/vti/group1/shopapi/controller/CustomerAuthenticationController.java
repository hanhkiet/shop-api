package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.dto.RegisterDto;
import com.vti.group1.shopapi.dto.UserDto;
import com.vti.group1.shopapi.service.CustomerAuthService;
import com.vti.group1.shopapi.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/auth")
@RequiredArgsConstructor
public class CustomerAuthenticationController {

    private final CustomerAuthService customerAuthService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(
            @RequestBody CredentialsDto credentialsDto) {
        UserDto userDto = customerAuthService.login(credentialsDto);

        HttpHeaders headers = createHeadersWithCookie(userDto);

        return ResponseEntity.ok().headers(headers).body(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(
            @RequestBody RegisterDto registerDto) {
        UserDto userDto = customerAuthService.register(registerDto);
        HttpHeaders headers = createHeadersWithCookie(userDto);

        return ResponseEntity.ok().headers(headers).body(userDto);
    }

    private HttpHeaders createHeadersWithCookie(UserDto userDto) {
        HttpHeaders headers = new HttpHeaders();
        String token = jwtService.createToken(userDto.getUsername());
        headers.add(HttpHeaders.SET_COOKIE, "jwt=" + token + "; Path=/; HttpOnly; " +
                "SameSite=None");
        return headers;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok().body("Logout successfully");
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @AuthenticationPrincipal String name, @RequestBody CredentialsDto credentialsDto) {
        customerAuthService.changePassword(name, credentialsDto);
        return ResponseEntity.ok().body("Change password successfully");
    }
}
