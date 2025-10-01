package com.spring.EventManagementSystem.service;

import com.spring.EventManagementSystem.entity.Users;

import java.util.List;

public interface UserServiceLayer {

    public Users findById(Long id);

    public List<Users> find();

}
