package com.vti.group1.shopapi.utils;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if(strings == null || strings.isEmpty()) {
            return null;
        }
        return String.join(",", strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if(s == null || s.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(s.split(","));
    }
}
