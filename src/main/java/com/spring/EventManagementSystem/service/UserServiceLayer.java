package com.spring.EventManagementSystem.service;

import com.spring.EventManagementSystem.entity.Users;

import java.util.List;


public interface UserServiceLayer {

    public Users findById(long id);

    public List<Users> find();

    public Users getByUserName(String username);

}
