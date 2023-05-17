package com.vti.group1.shopapi.utils;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public final class JwtUtil {
    public static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static final long EXPIRATION_TIME = (long) 1000 * 60 * 60 * 2; // 2 hours

    private JwtUtil() {
        throw new AssertionError("Cannot create instance of JwtUtil");
    }
}
