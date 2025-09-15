package com.spring.EventManagementSystem.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.EventManagementSystem.entity.Registration;

@Repository
public interface RegistrationJPARepository extends JpaRepository<Registration, Long> {

    ArrayList<Long> findAllByEventId(Long eventId);
    
}
