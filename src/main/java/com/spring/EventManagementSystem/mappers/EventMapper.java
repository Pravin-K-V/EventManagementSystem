package com.spring.EventManagementSystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.EventManagementSystem.dto.EventDTO;
import com.spring.EventManagementSystem.dto.EventUpdateDTO;
import com.spring.EventManagementSystem.dto.RegistrationDTO;
import com.spring.EventManagementSystem.dto.UserResponseDTO;
import com.spring.EventManagementSystem.entity.Events;
import com.spring.EventManagementSystem.entity.Registration;
import com.spring.EventManagementSystem.entity.User;

@Mapper(componentModel = "spring")

public interface EventMapper {

    EventDTO toEventDto(Events event);

    @Mapping(target = "id", ignore = true)
    Events toEvents(EventDTO eventDTO);

    Events toEvents(EventUpdateDTO eventUpdateDTO);

    EventUpdateDTO toEventUpdateDTO(Events event);

    @Mapping(target = "id", ignore = true)
    Registration toRegistration(RegistrationDTO regDto);

    RegistrationDTO toRegistrationDTO(Registration reg);

    UserResponseDTO toUserResponseDTO(User user);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toUser(UserResponseDTO userResponseDTO);
    
}
