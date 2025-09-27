package com.spring.EventManagementSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.EventManagementSystem.entity.User;
import com.spring.EventManagementSystem.service.UserServiceLayer;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    public UserServiceLayer userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUserName(username);
        return new CustomUserDetail(user);
    }
    
}
