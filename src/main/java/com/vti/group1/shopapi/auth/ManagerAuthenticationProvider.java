package com.vti.group1.shopapi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class ManagerAuthenticationProvider implements AuthenticationProvider {

    private final ManagerDetailsService managerDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ManagerAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
        var username = authentication.getName();
        var password = authentication.getCredentials().toString();

        var managerDetails = managerDetailsService.loadUserByUsername(username);

        if (!passwordEncoder.matches(password, managerDetails.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }

        return new ManagerAuthenticationToken(managerDetails, password, managerDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ManagerAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
