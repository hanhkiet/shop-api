package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.service.CustomerAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/account")
@RequiredArgsConstructor
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @GetMapping
    public ResponseEntity<AccountDto> getAccount(
            @AuthenticationPrincipal String name) {
        AccountDto account = customerAccountService.loadAccount(name);
        return ResponseEntity.ok(account);
    }

}

