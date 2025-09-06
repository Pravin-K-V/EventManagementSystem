package com.spring.EventManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Events {
    private Long id;
    private String title;
    private String location;
    private String date;
    private String time;
    private String organizerId;

}
