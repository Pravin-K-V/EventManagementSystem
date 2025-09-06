package com.spring.EventManagementSystem.service;

import com.spring.EventManagementSystem.dao.UserJPARepository;
import com.spring.EventManagementSystem.entity.User;

import java.util.List;

public class UserServiceLayerImpl implements UserServiceLayer{

    public UserJPARepository myUserJPARepository;

    @Override
    public List<User> find(){
        return myUserJPARepository.findAll();
    }

    @Override
    public User findById(int id){
        return myUserJPARepository.findById(id);
    }

}
