package com.spring.EventManagementSystem.service;

import com.spring.EventManagementSystem.component.CSVDataLoader;
import com.spring.EventManagementSystem.dao.UserJPARepository;
import com.spring.EventManagementSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceLayerImpl implements UserServiceLayer{

    private final CSVDataLoader csvDataLoader;
    public UserJPARepository myUserJPARepository;

    @Autowired
    public UserServiceLayerImpl(CSVDataLoader csvDataLoader,UserJPARepository userJPARepository) {
        this.csvDataLoader = csvDataLoader;
        this.myUserJPARepository = userJPARepository;
    }

    @Override
    public List<User> find(){
        return myUserJPARepository.findAll();
    }

    @Override
    public User findById(Long id){

        Optional<User> userList = myUserJPARepository.findById(id);
        if(userList.isPresent()){
            return userList.get();
        }
        else{
            throw new RuntimeException("User is not found for the given user id: "+id);
        }
    }

}
