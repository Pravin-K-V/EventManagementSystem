package com.spring.EventManagementSystem.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private Long userId;
    private Long eventId;
    private String status;
}
