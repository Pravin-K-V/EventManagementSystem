package com.spring.EventManagementSystem.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
}
