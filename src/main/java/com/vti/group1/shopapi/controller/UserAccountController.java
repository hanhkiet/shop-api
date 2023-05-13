package com.vti.group1.shopapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.group1.shopapi.entity.OrderAddress;
import com.vti.group1.shopapi.services.OrderAddressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class UserAccountController {

    private final OrderAddressService orderAddressService;

    @GetMapping("/addresses")
    public ResponseEntity<List<OrderAddress>> getAddresses() {
        return ResponseEntity.ok(orderAddressService.getAddresses());
    }

    @PostMapping("/addresses")
    public ResponseEntity<OrderAddress> addAddress(
            @RequestBody OrderAddress orderAddress) {
        return ResponseEntity.ok(orderAddressService.addAddress(orderAddress));
    }

    @DeleteMapping("/addresses")
    public ResponseEntity<Void> deleteAddress(
            @RequestBody OrderAddress orderAddress) {
        orderAddressService.deleteAddress(orderAddress);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/addresses")
    public ResponseEntity<OrderAddress> updateAddress(
            @RequestBody OrderAddress orderAddress) {
        return ResponseEntity.ok(orderAddressService.updateAddress(orderAddress));
    }
}
