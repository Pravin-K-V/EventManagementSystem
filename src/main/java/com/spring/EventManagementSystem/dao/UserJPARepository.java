package com.spring.EventManagementSystem.dao;

import com.spring.EventManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer> {

}
