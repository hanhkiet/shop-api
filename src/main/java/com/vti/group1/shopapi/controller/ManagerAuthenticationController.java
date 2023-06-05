package com.vti.group1.shopapi.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.dto.ManagerDataDto;
import com.vti.group1.shopapi.service.JwtService;
import com.vti.group1.shopapi.service.ManagerAuthService;
import com.vti.group1.shopapi.service.TokenService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/manager/auth")
@Transactional
@RequiredArgsConstructor
public class ManagerAuthenticationController {

    private final ManagerAuthService managerAuthService;
    private final JwtService jwtService;
    private final TokenService tokenService;

    @GetMapping
    public String hello() {
        return "Hello, Manager!";
    }

    @PostMapping("/login")
    public ResponseEntity<ManagerDataDto> login(@RequestBody CredentialsDto credentialsDto) {
        ManagerDataDto managerDataDto = managerAuthService.login(credentialsDto);
        String token = jwtService.createToken(managerDataDto.getUsername());
        HttpHeaders headers = createHeadersWithCookie(token);
        tokenService.saveToken(managerDataDto.getUsername(), token);

        return ResponseEntity.ok().headers(headers).body(managerDataDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            @AuthenticationPrincipal String name) {
        managerAuthService.logout(name);
        return ResponseEntity.ok().body("Logout successfully!");
    }

    @GetMapping("/refresh")
    public ResponseEntity<AccountDto> refresh(
            @AuthenticationPrincipal String name) {
        AccountDto accountDto = managerAuthService.refresh(name);
        String token = jwtService.createToken(accountDto.getUsername());
        HttpHeaders headers = createHeadersWithCookie(token);
        tokenService.saveToken(accountDto.getUsername(), token);

        return ResponseEntity.ok().headers(headers).body(accountDto);
    }

    private HttpHeaders createHeadersWithCookie(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE,
                "managerJwt=" + token + "; Path=/; HttpOnly; " + "SameSite=None; Secure");

        return headers;
    }
}
