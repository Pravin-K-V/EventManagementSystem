package com.spring.EventManagementSystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.EventManagementSystem.entity.Users;
import com.spring.EventManagementSystem.repository.UserJPARepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    public UserJPARepository myUserJPARepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = myUserJPARepository.findByemail(username);
        return new CustomUserDetail(user);
    }
    
}
