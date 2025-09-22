package com.spring.EventManagementSystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.EventManagementSystem.dto.RegistrationDTO;
import com.spring.EventManagementSystem.entity.Registration;
import com.spring.EventManagementSystem.mappers.EventMapper;
import com.spring.EventManagementSystem.repository.RegistrationJPARepository;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationJPARepository regRepo;
    @Autowired
    private EventMapper eventMapper;

    public void bookEvent(RegistrationDTO registrationDTO) {
        regRepo.save(eventMapper.toRegistration(registrationDTO));
    }

    public ArrayList<Registration> getAllUsersRegistered(Long eventId){
        return regRepo.findAllByEventId(eventId);

    }

}
