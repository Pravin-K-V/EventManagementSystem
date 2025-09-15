package com.spring.EventManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventUpdateDTO {
    private Long id;
    private String status;
    private String title;
    private String location;
    private String date;
    private String time;
    private String organizerId;
}
