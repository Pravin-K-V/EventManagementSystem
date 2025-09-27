package com.spring.EventManagementSystem.repository;

import com.spring.EventManagementSystem.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{

}
