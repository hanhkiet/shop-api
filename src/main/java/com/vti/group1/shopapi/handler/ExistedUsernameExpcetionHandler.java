package com.vti.group1.shopapi.handler;

import com.vti.group1.shopapi.exception.ExistedUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExistedUsernameExpcetionHandler {
    @ExceptionHandler(ExistedUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleExistedUsernameException(ExistedUsernameException ex) {
        return ex.getMessage();
    }
}
