package com.vti.group1.shopapi.exception;

public class ExistedUsernameException extends RuntimeException {
    public ExistedUsernameException(String message) {
        super(message);
    }
}
