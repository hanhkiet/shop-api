package com.vti.group1.shopapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.dto.CredentialsDto;
import com.vti.group1.shopapi.dto.RegisterDto;
import com.vti.group1.shopapi.dto.UserDto;
import com.vti.group1.shopapi.entity.Customer;
import com.vti.group1.shopapi.entity.Role;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.RestException;
import com.vti.group1.shopapi.repository.CustomerRepository;
import com.vti.group1.shopapi.repository.TokenRepository;
import com.vti.group1.shopapi.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerAuthService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initDefaultCustomer() {
        if (!userRepository.existsByUsername("guest")) {
            User user = User.builder().username("guest").role(Role.CUSTOMER).build();
            user.setPassword(passwordEncoder.encode("12345asd"));

            Customer customer = Customer.builder().firstName("First name").lastName("Last name").user(user)
                    .build();

            customerRepository.save(customer);
        }
    }

    public UserDto login(CredentialsDto credentialsDto) {
        String username = credentialsDto.getUsername();
        String password = credentialsDto.getPassword();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RestException(HttpStatus.UNAUTHORIZED,
                        "Invalid " + "credentials"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RestException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        Customer customer = customerRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RestException(HttpStatus.UNAUTHORIZED,
                        "Invalid " + "credentials"));

        return UserDto.builder().uuid(customer.getUuid()).username(user.getUsername())
                .firstName(customer.getFirstName()).lastName(customer.getLastName()).build();
    }

    public UserDto register(RegisterDto registerDto) {
        String username = registerDto.getUsername();
        String password = registerDto.getPassword();
        String firstName = registerDto.getFirstName();
        String lastName = registerDto.getLastName();

        if (firstName == null || firstName.isEmpty()) {
            throw new RestException(HttpStatus.BAD_REQUEST, "First name is required");
        }

        if (lastName == null || lastName.isEmpty()) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Last name is required");
        }

        if (username == null || username.isEmpty()) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Username is required");
        }

        if (password == null || password.isEmpty()) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Password is required");
        }

        if (userRepository.existsByUsername(username)) {
            throw new RestException(HttpStatus.BAD_REQUEST, String.format(
                    "Username %s already " + "exists", username));
        }

        User user = User.builder().username(username).role(Role.CUSTOMER).build();
        user.setPassword(passwordEncoder.encode(password));

        Customer customer = Customer.builder().firstName(firstName).lastName(lastName).user(user)
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        return UserDto.builder().uuid(savedCustomer.getUuid()).username(savedCustomer.getUser()
                .getUsername())
                .firstName(savedCustomer.getFirstName()).lastName(savedCustomer.getLastName())
                .build();
    }

    public void logout(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RestException(HttpStatus.UNAUTHORIZED,
                        "Invalid " + "credentials"));

        tokenRepository.deleteById(user.getId());
        SecurityContextHolder.clearContext();
    }

    public void changePassword(String username, CredentialsDto credentialsDto) {
        String password = credentialsDto.getPassword();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RestException(HttpStatus.UNAUTHORIZED,
                        "Invalid " + "credentials"));

        user.setPassword(passwordEncoder.encode(password));
        userRepository.saveAndFlush(user);
    }
}
