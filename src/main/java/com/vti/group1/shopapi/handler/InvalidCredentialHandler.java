package com.vti.group1.shopapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vti.group1.shopapi.exception.InvalidCredentialException;
import com.vti.group1.shopapi.model.ErrorMessage;

@RestControllerAdvice
public class InvalidCredentialHandler {
    @ExceptionHandler(InvalidCredentialException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidCredentialException(InvalidCredentialException ex) {

        return ErrorMessage.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
    }
}
