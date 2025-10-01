package com.spring.EventManagementSystem.repository;

import com.spring.EventManagementSystem.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJPARepository extends JpaRepository<Users,Long>{

    Optional<Users> findByEmail(String email);

}
