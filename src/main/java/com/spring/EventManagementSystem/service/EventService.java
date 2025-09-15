package com.spring.EventManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.EventManagementSystem.dto.EventDTO;
import com.spring.EventManagementSystem.dto.EventUpdateDTO;
import com.spring.EventManagementSystem.mappers.EventMapper;
import com.spring.EventManagementSystem.repository.EventRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;

    public void registerEvent(EventDTO registrationDto) {
        eventRepository.save(eventMapper.toEvents(registrationDto));
    }

    public EventDTO getEvent(Long id) {
        return eventMapper.toEventDto(eventRepository.findById(id).orElse(null));
    }

    public EventDTO[] getAllEvents() {
        return eventRepository.findAll().stream()
        .map(eventMapper::toEventDto)
        .toArray(EventDTO[]::new);
    }

    public void updateEvent(EventUpdateDTO eventUpdateDto) {
        eventRepository.save(eventMapper.toEvents(eventUpdateDto));
    }

}
