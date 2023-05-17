package com.vti.group1.shopapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vti.group1.shopapi.exception.InvalidAddressDataException;
import com.vti.group1.shopapi.model.ErrorMessage;

@RestControllerAdvice
public class InvalidAddressDataHandler {
    @ExceptionHandler(InvalidAddressDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidAddressDataException(InvalidAddressDataException ex) {

        return ErrorMessage.builder()
                .message(ex.getMessage())
                .build();
    }
}
