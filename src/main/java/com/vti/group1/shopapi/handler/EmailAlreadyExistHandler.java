package com.vti.group1.shopapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vti.group1.shopapi.exception.EmailAlreadyExistException;
import com.vti.group1.shopapi.model.ErrorMessage;

@RestControllerAdvice
public class EmailAlreadyExistHandler {
    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleEmailAlreadyExistException(EmailAlreadyExistException ex) {

        return ErrorMessage.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
    }
}
