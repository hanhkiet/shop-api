package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.entity.Order;
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
    public ResponseEntity<List<Order>> getAllOrders(
            @AuthenticationPrincipal String name) {
        return ResponseEntity.ok(orderService.getAllOrders(name));
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(
            @AuthenticationPrincipal String name, @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok("Checkout successfully");
    }
}
