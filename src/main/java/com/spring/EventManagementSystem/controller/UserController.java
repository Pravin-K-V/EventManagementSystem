package com.spring.EventManagementSystem.controller;

import com.spring.EventManagementSystem.entity.Users;
import com.spring.EventManagementSystem.service.UserServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceLayer myServiceLayer;

    @GetMapping("/users")
    public String displayUserById(){

        List<Users> usersList = myServiceLayer.find();
        for(Users tempUsers : usersList){
            System.out.println("User name"+ tempUsers.getName());
            System.out.println("email"+ tempUsers.getEmail());
            System.out.println("phone number"+ tempUsers.getPhoneNumber());
            System.out.println("id"+ tempUsers.getId());
        }

        return "users added and displayed";

    }

}
