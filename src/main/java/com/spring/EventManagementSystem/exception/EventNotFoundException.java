package com.spring.EventManagementSystem.exception;

public class EventNotFoundException extends RuntimeException {
    
    public EventNotFoundException(String mess){
        super(mess);
    }
}
