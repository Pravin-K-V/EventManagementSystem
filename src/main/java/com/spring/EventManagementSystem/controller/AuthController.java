package com.spring.EventManagementSystem.controller;

import com.spring.EventManagementSystem.entity.Users;
import com.spring.EventManagementSystem.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    public AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return authService.verify(user);
    }

}
