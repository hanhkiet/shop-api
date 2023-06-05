package com.vti.group1.shopapi.mapper;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.entity.Customer;

public interface CustomerMapper {
    AccountDto toDto(Customer customer);

    Customer toEntity(AccountDto accountDto);
}
