package com.vti.group1.shopapi.services;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.entity.OrderAddress;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.AddressNotFoundException;
import com.vti.group1.shopapi.exception.InvalidAddressDataException;
import com.vti.group1.shopapi.repository.OrderAddressRepository;
import com.vti.group1.shopapi.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderAddressService {

    private final OrderAddressRepository orderAddressRepository;
    private final UserRepository userRepository;

    public List<OrderAddress> getAddresses() {
        return orderAddressRepository.findAll();
    }

    public OrderAddress addAddress(OrderAddress orderAddress) throws InvalidAddressDataException {
        if (orderAddress.getStreet() == null || orderAddress.getStreet().isEmpty()) {
            throw new InvalidAddressDataException("Street is required");
        }

        if (orderAddress.getDistrict() == null || orderAddress.getDistrict().isEmpty()) {
            throw new InvalidAddressDataException("District is required");
        }

        if (orderAddress.getCity() == null || orderAddress.getCity().isEmpty()) {
            throw new InvalidAddressDataException("City is required");
        }

        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(userEmail);
        orderAddress.setUser(user);

        return orderAddressRepository.save(orderAddress);
    }

    public void deleteAddress(OrderAddress orderAddress) throws AddressNotFoundException {
        OrderAddress address = orderAddressRepository.findById(orderAddress.getUuid())
                .orElseThrow(() -> new AddressNotFoundException("Address not found"));

        orderAddressRepository.delete(address);
    }

    public OrderAddress updateAddress(OrderAddress orderAddress) throws AddressNotFoundException {
        OrderAddress address = orderAddressRepository.findById(orderAddress.getUuid())
                .orElseThrow(() -> new AddressNotFoundException("Address not found"));

        return orderAddressRepository.save(address);
    }
}
