package com.vti.group1.shopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/account")
@RequiredArgsConstructor
public class CustomerAccountController {

    @GetMapping
    public String getAccount() {
        return "Customer account";
    }

}

