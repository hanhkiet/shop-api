package com.vti.group1.shopapi.service;

import com.vti.group1.shopapi.entity.Role;
import com.vti.group1.shopapi.entity.User;
import com.vti.group1.shopapi.exception.ExistedUsernameException;
import com.vti.group1.shopapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(String username, String password) {

        if (userRepository.existsByUsername(username)) {
            throw new ExistedUsernameException("Username already exists!");
        }

        var newUser = User.builder().username(username).password(passwordEncoder.encode(password))
                .role(Role.CUSTOMER).build();

        userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, newUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
