package com.spring.EventManagementSystem.service;

 import com.spring.EventManagementSystem.component.CSVDataLoader;
import com.spring.EventManagementSystem.dto.UserResponseDTO;
import com.spring.EventManagementSystem.mappers.EventMapper;
import com.spring.EventManagementSystem.repository.UserJPARepository;
import com.spring.EventManagementSystem.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceLayerImpl implements UserServiceLayer{

    private final CSVDataLoader csvDataLoader;
    public UserJPARepository myUserJPARepository;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceLayerImpl(CSVDataLoader csvDataLoader ,UserJPARepository userJPARepository) {
        this.csvDataLoader = csvDataLoader;
        this.myUserJPARepository = userJPARepository;
    }

    @Autowired
    public JWTService jwtService;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<UserResponseDTO> find(){
        return myUserJPARepository.findAll()
                .stream()
                .map(user-> new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO findById(Long id){
        Optional<Users> user = myUserJPARepository.findById(id);
        if(user.isPresent()){
            return eventMapper.toUserResponseDTO(user.get());
        }
        else{
            throw new RuntimeException("User is not found for the given user id: "+id);
        }
    }

    @Override
    public Users getByUserName(String username) {
        return myUserJPARepository.findByemail(username);
    }

    @Override
    public Users registerUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        myUserJPARepository.save(user);
        return user;
    }

    @Override
    public String verify(Users user) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if(auth.isAuthenticated()){
            return jwtService.generateToken(user.getEmail());
        }
        else {
            throw new RuntimeException("Invalid login credentials");
        }
    }

}
