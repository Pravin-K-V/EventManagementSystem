package com.spring.EventManagementSystem.service;

import com.spring.EventManagementSystem.entity.User;

import java.util.List;

public interface UserServiceLayer {

    public User findById(int id);

    public List<User> find();

}
