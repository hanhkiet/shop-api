package com.vti.group1.shopapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestException extends RuntimeException {
    private HttpStatus status;
    private String message;
    public RestException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
