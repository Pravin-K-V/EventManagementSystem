package com.spring.EventManagementSystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.EventManagementSystem.dto.EventDTO;
import com.spring.EventManagementSystem.entity.Events;

@Mapper(componentModel = "spring")

public interface EventMapper {

    EventDTO toEventDto(Events event);

    @Mapping(target = "id", ignore = true)
    Events toEvents(EventDTO eventDTO);
    
}
