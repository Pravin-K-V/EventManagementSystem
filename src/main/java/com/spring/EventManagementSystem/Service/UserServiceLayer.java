package com.spring.EventManagementSystem.Service;

import com.spring.EventManagementSystem.entity.User;

import java.util.List;

public interface UserServiceLayer {

    public User findById();

    public List<User> find();

}
