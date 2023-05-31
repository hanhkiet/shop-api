package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.dto.AddressDto;
import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.service.CustomerAccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/account")
@Transactional
@RequiredArgsConstructor
public class CustomerAccountController {

    private final CustomerAccountService customerAccountService;

    @GetMapping
    public ResponseEntity<AccountDto> getAccount(
            @AuthenticationPrincipal String name) {

        AccountDto account = customerAccountService.loadAccount(name);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/password")
    public ResponseEntity<Void> updatePassword(
            @RequestBody CredentialsDto credentialsDto) {

        customerAccountService.updatePassword(credentialsDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<AccountDto> updateAccount(AccountDto accountDto) {
        AccountDto account = customerAccountService.updateAccount(accountDto);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDto>> getAddresses(
            @AuthenticationPrincipal String name) {

        List<AddressDto> addresses = customerAccountService.getAddresses(name);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/addresses")
    public ResponseEntity<AddressDto> addAddress(
            @AuthenticationPrincipal String name, @RequestBody AddressDto addressDto) {

        AddressDto newAddress = customerAccountService.addAddress(name, addressDto);
        return ResponseEntity.ok(newAddress);
    }

    @PutMapping("/addresses/{uuid}")
    public ResponseEntity<AddressDto> updateAddress(
            @PathVariable String uuid, @RequestBody AddressDto addressDto) {

        AddressDto updatedAddress = customerAccountService.updateAddress(uuid, addressDto);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/addresses/{uuid}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String uuid) {
        customerAccountService.deleteAddress(uuid);
        return ResponseEntity.ok().build();
    }
}

