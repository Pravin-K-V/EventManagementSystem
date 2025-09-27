package com.spring.EventManagementSystem.service;

import com.spring.EventManagementSystem.component.CSVDataLoader;
import com.spring.EventManagementSystem.repository.UserJPARepository;
import com.spring.EventManagementSystem.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
    public List<Users> find(){
        return myUserJPARepository.findAll();
    }

    @Override
    public Users findById(long id){

        Optional<Users> userList = myUserJPARepository.findById(id);
        if(userList.isPresent()){
            return userList.get();
        }
        else{
            throw new RuntimeException("User is not found for the given user id: "+id);
        }
    }

    @Override
    public Users getByUserName(String username) {
        return myUserJPARepository.findByemail(username);
    }

}
