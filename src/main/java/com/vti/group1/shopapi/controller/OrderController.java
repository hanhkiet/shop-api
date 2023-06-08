package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.CheckoutDto;
import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/orders")
@Transactional
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(
            @AuthenticationPrincipal String name) {
        return ResponseEntity.ok(orderService.getAllOrders(name));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDto> getOrder(
            @AuthenticationPrincipal String name, @PathVariable String uuid) {
        return ResponseEntity.ok(orderService.getOrder(uuid));
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(
            @AuthenticationPrincipal String name, @RequestBody CheckoutDto checkoutDto) {
        orderService.checkout(name, checkoutDto);
        return ResponseEntity.ok("Checkout successfully");
    }

}
