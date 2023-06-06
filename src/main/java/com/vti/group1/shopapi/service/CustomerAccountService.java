package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.dto.AccountDto;
import com.vti.group1.shopapi.dto.AddressDto;
import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.entity.Customer;
import com.vti.group1.shopapi.entity.Order;
import com.vti.group1.shopapi.entity.OrderAddress;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.mapper.AddressMapper;
import com.vti.group1.shopapi.mapper.CustomerMapper;
import com.vti.group1.shopapi.repository.CustomerRepository;
import com.vti.group1.shopapi.repository.OrderAddressRepository;
import com.vti.group1.shopapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerAccountService {
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;
    private final OrderAddressRepository orderAddressRepository;
    private final UserRepository userRepository;
    private final AddressMapper addressMapper;
    private final CustomerMapper customerMapper;


    public AccountDto loadAccount(String username) {
        Customer customer = findCustomerByUsername(username);
        return customerMapper.toDto(customer);
    }

    private Customer findCustomerByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "User not found"));

        return customerRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "Customer not found"));
    }

    public AccountDto updateAccount(AccountDto accountDto) {
        Customer customer = customerMapper.toEntity(accountDto);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    public List<AddressDto> getAddresses(String username) {
        Customer customer = findCustomerByUsername(username);

        List<OrderAddress> addresses =
                orderAddressRepository.findByCustomerUuid(customer.getUuid());
        return addresses.stream().map(addressMapper::toDto).toList();
    }

    public AddressDto addAddress(String name, AddressDto addressDto) {
        Customer customer = findCustomerByUsername(name);

        OrderAddress orderAddress = OrderAddress.builder()
                .recipientName(addressDto.getRecipientName())
                .recipientPhone(addressDto.getRecipientPhone()).street(addressDto.getStreet())
                .district(addressDto.getDistrict()).city(addressDto.getCity()).customer(customer)
                .build();

        OrderAddress savedAddress = orderAddressRepository.save(orderAddress);
        return addressMapper.toDto(savedAddress);
    }

    public AddressDto updateAddress(String uuid, AddressDto addressDto) {
        OrderAddress orderAddress = orderAddressRepository.findById(uuid)
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "Address not found"));

        orderAddress.setRecipientName(addressDto.getRecipientName());
        orderAddress.setRecipientPhone(addressDto.getRecipientPhone());
        orderAddress.setStreet(addressDto.getStreet());
        orderAddress.setDistrict(addressDto.getDistrict());
        orderAddress.setCity(addressDto.getCity());

        OrderAddress savedAddress = orderAddressRepository.save(orderAddress);
        return addressMapper.toDto(savedAddress);
    }

    public void deleteAddress(String uuid) {
        orderAddressRepository.deleteById(uuid);
    }

    public void updatePassword(CredentialsDto oldCredentials, CredentialsDto newCredentials) {
        User user = userRepository.findByUsername(newCredentials.getUsername())
                .orElseThrow(() -> new RestException(HttpStatus.BAD_REQUEST, "User not found"));

        if (!passwordEncoder.matches(oldCredentials.getPassword(), user.getPassword())) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Invalid credentials");
        }

        user.setPassword(passwordEncoder.encode(newCredentials.getPassword()));
        userRepository.save(user);
    }

    public List<Order> getOrders(String name) {
        Customer customer = findCustomerByUsername(name);
        return customer.getOrders();
    }
}
