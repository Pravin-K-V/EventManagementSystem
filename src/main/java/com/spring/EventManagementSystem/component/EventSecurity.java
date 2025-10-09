package com.spring.EventManagementSystem.component;

import com.spring.EventManagementSystem.dto.EventDTO;
import com.spring.EventManagementSystem.repository.EventRepository;
import com.spring.EventManagementSystem.security.CustomUserDetail;
import com.spring.EventManagementSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("eventSecurity")
public class EventSecurity {

    @Autowired
    private EventService eventService;

    public boolean isOwner(Authentication authentication, Long id){
        CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
        EventDTO requestedEvent = eventService.getEvent(id);
        return requestedEvent.getOrganizerId() == userDetails.getId();

    }

}
