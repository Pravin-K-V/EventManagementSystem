package com.spring.EventManagementSystem.mappers;

import com.spring.EventManagementSystem.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spring.EventManagementSystem.dto.EventDTO;
import com.spring.EventManagementSystem.dto.EventUpdateDTO;
import com.spring.EventManagementSystem.dto.RegistrationDTO;
import com.spring.EventManagementSystem.dto.UserResponseDTO;
import com.spring.EventManagementSystem.entity.Events;
import com.spring.EventManagementSystem.entity.Registration;

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

    UserResponseDTO toUserResponseDTO(Users users);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    Users toUser(UserResponseDTO userResponseDTO);
    
}
