package com.vti.group1.shopapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {

    private int status;
    private String message;
}