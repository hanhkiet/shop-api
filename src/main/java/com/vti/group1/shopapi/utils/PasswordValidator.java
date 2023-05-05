package com.vti.group1.shopapi.utils;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
    // private static final String PASSWORD_REGEX =
    // "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$";
    // private static final Pattern PASSWORD_PATTERN =
    // Pattern.compile(PASSWORD_REGEX);

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}
