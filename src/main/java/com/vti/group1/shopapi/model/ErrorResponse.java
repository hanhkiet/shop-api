package com.vti.group1.shopapi.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;
    private LocalDate timestamp;
}
