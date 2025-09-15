package com.spring.EventManagementSystem.service;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.EventManagementSystem.dto.RegistrationDTO;
import com.spring.EventManagementSystem.dto.UserResponseDTO;
import com.spring.EventManagementSystem.mappers.EventMapper;
import com.spring.EventManagementSystem.repository.RegistrationJPARepository;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationJPARepository regRepo;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private UserServiceLayerImpl userServiceLayerImpl;

    public void bookEvent(RegistrationDTO registrationDTO) {
        regRepo.save(eventMapper.toRegistration(registrationDTO));
    }


    public ArrayList<UserResponseDTO> getAllEnrolledUsers(Long eventId) {
       ArrayList<Long> userIds = regRepo.findAllByEventId(eventId);
       ArrayList<UserResponseDTO> allUsers = userIds.stream()
                                                .map(id -> userServiceLayerImpl.findById(id))
                                                .map(a -> eventMapper.toUserResponseDTO(a))
                                                .collect(Collectors.toCollection(ArrayList::new));
        return allUsers;

    }


}
