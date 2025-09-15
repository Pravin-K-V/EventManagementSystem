package com.spring.EventManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.EventManagementSystem.dto.EventDTO;
import com.spring.EventManagementSystem.dto.EventUpdateDTO;
import com.spring.EventManagementSystem.service.EventService;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/registerEvent")
    public ResponseEntity<EventDTO> registerEvent(@RequestBody EventDTO registrationDto) {
        eventService.registerEvent(registrationDto);
        return ResponseEntity.ok(registrationDto);
    }

    @GetMapping("/getEvent")
    public ResponseEntity<EventDTO> getRegisteredEvent(@RequestParam Long id) {
        EventDTO eventDto = eventService.getEvent(id);
        return ResponseEntity.ok(eventDto);
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<EventDTO[]> getAllEvents(){
        EventDTO[] events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/updateEvent")
    public ResponseEntity<EventUpdateDTO> updateEvent(@RequestBody EventUpdateDTO eventUpdateDto){
        eventService.updateEvent(eventUpdateDto);
        return ResponseEntity.ok(eventUpdateDto);
    }

}
