package com.spring.EventManagementSystem.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mess){
        super("User not found "+mess);
    }
}
