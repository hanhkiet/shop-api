package com.vti.group1.shopapi.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomerAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public CustomerAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public CustomerAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
