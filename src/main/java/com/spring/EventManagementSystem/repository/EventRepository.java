package com.spring.EventManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.EventManagementSystem.entity.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, Long> {
    
}
