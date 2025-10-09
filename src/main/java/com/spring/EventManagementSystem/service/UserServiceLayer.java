package com.spring.EventManagementSystem.service;

import com.spring.EventManagementSystem.dto.UserResponseDTO;
import com.spring.EventManagementSystem.entity.Users;

import java.util.List;


public interface UserServiceLayer {

    public UserResponseDTO findById(Long id);

    public List<UserResponseDTO> find();

    public Users getByUserName(String username);

    public Users registerUser(Users user);

    public String verify(Users user);

}
