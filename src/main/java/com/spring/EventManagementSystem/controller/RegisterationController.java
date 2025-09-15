package com.spring.EventManagementSystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.EventManagementSystem.dto.RegistrationDTO;
import com.spring.EventManagementSystem.dto.UserResponseDTO;
import com.spring.EventManagementSystem.service.RegistrationService;

@RestController
public class RegisterationController {
    @Autowired
    private RegistrationService regService;

    @PostMapping("/bookEvent")
    public ResponseEntity<RegistrationDTO> RegisterEvent(@RequestBody RegistrationDTO registrationDTO){
        regService.bookEvent(registrationDTO);
        return ResponseEntity.ok(registrationDTO);
    }


    @GetMapping("/getAllEnrolledUsers")
    public ResponseEntity<ArrayList<UserResponseDTO>> getAllEnrolledUsers(@RequestParam Long eventId){
        return ResponseEntity.ok(regService.getAllEnrolledUsers(eventId));
    }
}
