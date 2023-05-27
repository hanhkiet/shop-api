package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.entity.Customer;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.CustomerRepository;
import com.vti.group1.shopapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerAccountService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;


    public AccountDto loadAccount(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "User not found"));

        Customer customer = customerRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "Customer not found"));

        return AccountDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .username(user.getUsername())
                .build();
    }
}
