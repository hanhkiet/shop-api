package com.vti.group1.shopapi.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.entity.OrderAddress;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.InvalidAddressDataException;
import com.vti.group1.shopapi.model.AddAddressRequest;
import com.vti.group1.shopapi.model.DeleteAddressRequest;
import com.vti.group1.shopapi.model.UpdateAddressRequest;
import com.vti.group1.shopapi.repository.OrderAddressRepository;
import com.vti.group1.shopapi.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderAddressService {

    private static final Logger logger = LoggerFactory.getLogger(OrderAddressService.class);

    private final OrderAddressRepository orderAddressRepository;
    private final UserRepository userRepository;

    public List<OrderAddress> getAddresses() {
        logger.info("Get all addresses");

        return orderAddressRepository.findAll();
    }

    public OrderAddress addAddress(String userEmail, AddAddressRequest request) {
        logger.info("Add new address");

        if (request.getRecipientName() == null) {
            logger.error("Recipient name is null");
            throw new InvalidAddressDataException("Recipient name is null");
        }

        if (request.getRecipientPhone() == null) {
            logger.error("Recipient phone is null");
            throw new InvalidAddressDataException("Recipient phone is null");
        }

        if (request.getStreet() == null) {
            logger.error("Street is null");
            throw new InvalidAddressDataException("Street is null");
        }

        if (request.getDistrict() == null) {
            logger.error("District is null");
            throw new InvalidAddressDataException("District is null");
        }

        if (request.getCity() == null) {
            logger.error("City is null");
            throw new InvalidAddressDataException("City is null");
        }

        User user = userRepository.findByEmail(userEmail);

        if (user == null) {
            logger.error("User not found");
            throw new InvalidAddressDataException("User not found");
        }

        OrderAddress address = OrderAddress.builder()
                .user(user)
                .recipientName(request.getRecipientName())
                .recipientPhone(request.getRecipientPhone())
                .street(request.getStreet())
                .district(request.getDistrict())
                .city(request.getCity())
                .build();

        orderAddressRepository.save(address);

        address.setUser(null);
        return address;
    }

    public void deleteAddress(DeleteAddressRequest orderAddress) {
        logger.info("Delete address");

        String id = orderAddress.getAddressId();

        if (id == null) {
            logger.error("Address id is null");
            throw new InvalidAddressDataException("Address id is null");
        }

        Optional<OrderAddress> address = orderAddressRepository.findById(id);

        if (address.isEmpty()) {
            logger.error("Address not found");
            throw new InvalidAddressDataException("Address not found");
        }

        orderAddressRepository.delete(address.get());
    }

    public OrderAddress updateAddress(UpdateAddressRequest orderAddress) {
        logger.info("Update address");

        if (orderAddress.getAddressId() == null) {
            logger.error("Address id is null");
            throw new InvalidAddressDataException("Address id is null");
        }

        if (orderAddress.getRecipientName() == null) {
            logger.error("Recipient name is null");
            throw new InvalidAddressDataException("Recipient name is null");
        }

        if (orderAddress.getRecipientPhone() == null) {
            logger.error("Recipient phone is null");
            throw new InvalidAddressDataException("Recipient phone is null");
        }

        if (orderAddress.getStreet() == null) {
            logger.error("Street is null");
            throw new InvalidAddressDataException("Street is null");
        }

        if (orderAddress.getDistrict() == null) {
            logger.error("District is null");
            throw new InvalidAddressDataException("District is null");
        }

        if (orderAddress.getCity() == null) {
            logger.error("City is null");
            throw new InvalidAddressDataException("City is null");
        }

        Optional<OrderAddress> address = orderAddressRepository.findById(orderAddress.getAddressId());

        if (address.isEmpty()) {
            logger.error("Address not found");
            throw new InvalidAddressDataException("Address not found");
        }

        OrderAddress addressToUpdate = OrderAddress.builder()
                .uuid(address.get().getUuid())
                .user(address.get().getUser())
                .recipientName(orderAddress.getRecipientName())
                .recipientPhone(orderAddress.getRecipientPhone())
                .street(orderAddress.getStreet())
                .district(orderAddress.getDistrict())
                .city(orderAddress.getCity())
                .build();

        orderAddressRepository.save(addressToUpdate);
        addressToUpdate.setUser(null);

        return addressToUpdate;
    }
}
