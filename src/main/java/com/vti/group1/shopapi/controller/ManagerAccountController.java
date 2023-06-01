package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.dto.UpdatePasswordDto;
import com.vti.group1.shopapi.service.ManagerAccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager/account")
@Transactional
@RequiredArgsConstructor
public class ManagerAccountController {

    private final ManagerAccountService managerAccountService;

    @GetMapping
    public ResponseEntity<AccountDto> getAccount(
            @AuthenticationPrincipal String name) {
        AccountDto accountDto = managerAccountService.getAccount(name);
        return ResponseEntity.ok().body(accountDto);
    }

    @PutMapping
    public ResponseEntity<Void> updateAccount(
            @RequestBody AccountDto accountDto) {
        managerAccountService.updateAccount(accountDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/password")
    public ResponseEntity<Void> updatePassword(
            @RequestBody UpdatePasswordDto updatePasswordDto) {
        CredentialsDto oldCredentials = updatePasswordDto.getOldCredentials();
        CredentialsDto newCredentials = updatePasswordDto.getNewCredentials();

        managerAccountService.updatePassword(oldCredentials, newCredentials);
        return ResponseEntity.ok().build();
    }

}
