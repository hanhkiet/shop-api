package com.vti.group1.shopapi.controller;

import com.vti.group1.shopapi.dto.CheckoutDto;
import com.vti.group1.shopapi.dto.OrderDetailDto;
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
    public ResponseEntity<List<OrderDto>> getAllOrders(
            @AuthenticationPrincipal String name) {
        return ResponseEntity.ok(orderService.getAllOrders(name));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<List<OrderDetailDto>> getOrderDetails(@PathVariable String uuid) {
        return ResponseEntity.ok(orderService.getOrderDetails(uuid));
    }

    @PutMapping("/{uuid}/cancel")
    public ResponseEntity<OrderDto> cancelOrder(@PathVariable String uuid) {
        return ResponseEntity.ok(orderService.cancelOrder(uuid));

    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(
            @AuthenticationPrincipal String name, @RequestBody CheckoutDto checkoutDto) {
        return ResponseEntity.ok(orderService.checkout(name, checkoutDto));
    }
}
