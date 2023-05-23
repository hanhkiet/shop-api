package com.vti.group1.shopapi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class CustomerAuthenticationProvider implements AuthenticationProvider {

    private final CustomerDetailsService customerDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CustomerAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        var customer = customerDetailsService.loadUserByUsername(email);

        if (!passwordEncoder.matches(password, customer.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return new CustomerAuthenticationToken(customer, null, customer.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomerAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
