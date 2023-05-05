package com.vti.group1.shopapi.utils;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class NameValidator {
    private static final String NAME_REGEX = "^[a-zA-Z\\\\s]*$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    public boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }
}
