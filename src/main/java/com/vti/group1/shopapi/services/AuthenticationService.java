package com.vti.group1.shopapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.group1.shopapi.entity.Role;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.EmailAlreadyExistException;
import com.vti.group1.shopapi.exception.InvalidCredentialException;
import com.vti.group1.shopapi.model.LoginRequest;
import com.vti.group1.shopapi.model.LoginResponse;
import com.vti.group1.shopapi.model.LogoutResponse;
import com.vti.group1.shopapi.model.RegisterRequest;
import com.vti.group1.shopapi.model.RegisterResponse;
import com.vti.group1.shopapi.model.UserData;
import com.vti.group1.shopapi.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class.getName());

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest request) {

        if (isEmailAlreadyExist(request.getEmail())) {
            String info = String.format("%s is already registered", request.getEmail());
            logger.warn(info);

            throw new EmailAlreadyExistException(info);
        }

        return createResponseForRegisterRequest(request);
    }

    private boolean isEmailAlreadyExist(String email) {
        return userRepository.existsByEmail(email);
    }

    private RegisterResponse createResponseForRegisterRequest(RegisterRequest request) {

        User user = createUserFromRequestData(request);
        var newUser = userRepository.save(user);
        String jwt = jwtService.generateToken(newUser);

        UserData userData = UserData.builder()
                .uuid(newUser.getUuid())
                .name(newUser.getFirstName() + " " + newUser.getLastName())
                .email(newUser.getEmail())
                .build();

        return RegisterResponse.builder()
                .message("User registered successfully")
                .jwt(jwt)
                .userData(userData)
                .build();
    }

    private User createUserFromRequestData(RegisterRequest request) {
        String info = String.format("Creating user from request data for %s", request.getEmail());
        logger.info(info);

        return User.builder().firstName(request.getFirstName())
                .lastName(request.getLastName()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build();
    }

    public LoginResponse login(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password));
        } catch (Exception e) {
            logger.warn("Invalid credentials detected: " + email);
            throw new InvalidCredentialException("Invalid credentials: " + email);
        }

        return responseSuccessMessageWithToken(request);
    }

    private LoginResponse responseSuccessMessageWithToken(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        String jwt = jwtService.generateToken(user);

        UserData userData = UserData.builder()
                .uuid(user.getUuid())
                .name(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .build();

        String info = String.format("%s login successfully", user.getEmail());
        logger.info(info);

        return LoginResponse.builder()
                .message("User authenticated successfully")
                .jwt(jwt)
                .userData(userData)
                .build();
    }

    public LogoutResponse logout(HttpServletRequest request) {
        jwtService.clearAuthentication(request);

        return LogoutResponse.builder()
                .message("User logged out successfully")
                .build();
    }

    public LoginResponse authenticate(HttpServletRequest request) {
        String userEmail = request.getAttribute("userEmail").toString();
        String jwt = request.getHeader("Authorization").toString().substring(7);

        User user = userRepository.findByEmail(userEmail);

        UserData userData = UserData.builder()
                .uuid(user.getUuid())
                .name(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .build();

        String info = String.format("%s is authenticated successfully", user.getEmail());
        logger.info(info);

        return LoginResponse.builder()
                .message("User authenticated successfully")
                .jwt(jwt)
                .userData(userData)
                .build();
    }
}
