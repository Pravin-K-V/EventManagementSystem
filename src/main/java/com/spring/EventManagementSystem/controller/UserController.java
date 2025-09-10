package com.spring.EventManagementSystem.controller;

import com.spring.EventManagementSystem.entity.User;
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

        List<User> userList = myServiceLayer.find();
        System.out.println(userList.get(0));
//        for(User tempUser : userList){
//            System.out.println("User name"+ tempUser.getName());
//            System.out.println("email"+ tempUser.getEmail());
//            System.out.println("phone number"+ tempUser.getPhoneNumber());
//            System.out.println("id"+ tempUser.getId());
//        }

        return "users added and displayed";

    }

}
