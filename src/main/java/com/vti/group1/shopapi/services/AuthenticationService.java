package com.vti.group1.shopapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.group1.shopapi.auth.AuthenticationRequest;
import com.vti.group1.shopapi.auth.AuthenticationResponse;
import com.vti.group1.shopapi.auth.LogoutResponse;
import com.vti.group1.shopapi.auth.RegisterRequest;
import com.vti.group1.shopapi.entity.Role;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

        private final UserRepository userRepository;
        private final JwtService jwtService;
        private final BlacklistTokenService blacklistTokenService;
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
                        logger.info("Email is already registered: {}", user.getEmail());
                        return AuthenticationResponse.builder().message("Email is already registered").build();
                }

                var newUser = userRepository.save(user);
                logger.info("User registered successfully: {}", user.getUuid());

                var jwtToken = jwtService.generateToken(user);
                logger.info("Token generated successfully: {}", jwtToken);

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
                        logger.info("Email is not registered: {}", request.getEmail());
                        return AuthenticationResponse.builder().message("Email is not registered").build();
                }

                var jwtToken = jwtService.generateToken(user.get());
                logger.info("Token generated successfully: {}", jwtToken);

                return AuthenticationResponse.builder()
                                .message("User authenticated successfully")
                                .token(jwtToken)
                                .build();
        }

        public LogoutResponse logout(HttpServletRequest request) {

                String token = getTokenFromRequest(request);

                if (token == null) {
                        logger.warn("Non-token request detected");
                        return LogoutResponse.builder().message("User is not logged in").build();
                }

                if (blacklistTokenService.isTokenInBlacklist(token)) {
                        logger.warn("Token is already blacklisted");
                        return LogoutResponse.builder().message("User is not logged in").build();
                }

                logger.info("User logging out");

                blacklistTokenService.addTokenToBlacklist(token);

                logger.info("User logged out successfully");
                return LogoutResponse.builder().message("User logged out successfully").build();
        }

        private String getTokenFromRequest(HttpServletRequest request) {
                String bearerToken = request.getHeader("Authorization");

                if (bearerToken == null) {
                        return null;
                }

                if (StringUtils.hasText("bearerToken")
                                && bearerToken.startsWith("Bearer ")) {
                        return bearerToken.substring(7);
                }

                return null;
        }
}
