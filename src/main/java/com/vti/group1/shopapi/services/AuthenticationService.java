package com.vti.group1.shopapi.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.auth.AuthenticationRequest;
import com.vti.group1.shopapi.auth.AuthenticationResponse;
import com.vti.group1.shopapi.auth.RegisterRequest;
import com.vti.group1.shopapi.entity.Role;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final UserRepository userRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {

                final var user = User.builder().firstName(request.getFirstName())
                                .lastName(request.getLastName()).email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.CUSTOMER)
                                .build();

                var userInRepository = userRepository.findByEmail(request.getEmail());

                if (userInRepository.isPresent()) {
                        System.out.println(request.getEmail() + " is already registered");
                        return AuthenticationResponse.builder().message("Email is already registered").build();
                }

                var newUser = userRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .message("User registered successfully")
                                .uuid(newUser.getUuid())
                                .token(jwtToken).build();

        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {

                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                var user = userRepository.findByEmail(request.getEmail());

                if (user.isEmpty()) {
                        System.out.println(request.getEmail() + " is not registered");
                        return AuthenticationResponse.builder().message("Email is not registered").build();
                }

                var jwtToken = jwtService.generateToken(user.get());

                return AuthenticationResponse.builder()
                                .message("User authenticated successfully")
                                .token(jwtToken)
                                .build();
        }

}
