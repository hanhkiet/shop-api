package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.entity.Customer;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.mapper.CustomerMapper;
import com.vti.group1.shopapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerMapperImpl implements CustomerMapper {
    private final UserRepository userRepository;

    @Override
    public AccountDto toDto(Customer customer) {
        return AccountDto.builder().username(customer.getUser().getUsername())
                .firstName(customer.getFirstName()).lastName(customer.getLastName()).build();
    }

    @Override
    public Customer toEntity(AccountDto accountDto) {
        User user = userRepository.findByUsername(accountDto.getUsername())
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "User not found"));

        return Customer.builder().firstName(accountDto.getFirstName())
                .lastName(accountDto.getLastName()).user(user).build();
    }
}
