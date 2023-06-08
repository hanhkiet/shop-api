package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.OrderDto;
import com.vti.group1.shopapi.dto.ProductDto;
import com.vti.group1.shopapi.entity.Order;
import com.vti.group1.shopapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerAccountService customerAccountService;
    private final CustomerRepository customerRepository;

    public List<Order> getAllOrders(String name) {
        var customer = customerAccountService.findCustomerByUsername(name);
        return customer.getOrders();
    }
}
