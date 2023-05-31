package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.dto.ManagerDataDto;
import com.vti.group1.shopapi.service.JwtService;
import com.vti.group1.shopapi.service.ManagerAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager/auth")
@RequiredArgsConstructor
public class ManagerAuthenticationController {

    private final ManagerAuthService managerAuthService;
    private final JwtService jwtService;

    @GetMapping
    public String hello() {
        return "Hello, Manager!";
    }

    @PostMapping("/login")
    public ResponseEntity<ManagerDataDto> login(@RequestBody CredentialsDto credentialsDto) {
        ManagerDataDto managerDataDto = managerAuthService.login(credentialsDto);
        HttpHeaders headers = createHeadersWithCookie(managerDataDto);

        return ResponseEntity.ok().headers(headers).body(managerDataDto);
    }

    private HttpHeaders createHeadersWithCookie(ManagerDataDto managerDataDto) {
        HttpHeaders headers = new HttpHeaders();
        String token = jwtService.createToken(managerDataDto.getUsername());
        headers.add(HttpHeaders.SET_COOKIE,
                    "managerJwt=" + token + "; Path=/; HttpOnly; " + "SameSite=None; Secure");
        return headers;
    }
}
