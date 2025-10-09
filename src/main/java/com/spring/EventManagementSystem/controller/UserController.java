package com.spring.EventManagementSystem.controller;

import com.spring.EventManagementSystem.dto.UserResponseDTO;
import com.spring.EventManagementSystem.entity.Users;
import com.spring.EventManagementSystem.service.UserServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceLayer myServiceLayer;

    @GetMapping("/admin/users")
    public ResponseEntity<List<UserResponseDTO>>getAllUsers(){
        return ResponseEntity.ok(myServiceLayer.find());
    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(myServiceLayer.findById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user){
        return ResponseEntity.ok(myServiceLayer.registerUser(user));
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return myServiceLayer.verify(user);
    }

}
