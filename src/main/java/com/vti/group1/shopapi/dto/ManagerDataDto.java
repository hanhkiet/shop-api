package com.vti.group1.shopapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDataDto {
    private String uuid;
    private String username;
    private String firstName;
    private String lastName;
}
