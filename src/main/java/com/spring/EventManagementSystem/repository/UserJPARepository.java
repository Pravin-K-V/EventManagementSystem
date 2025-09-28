package com.spring.EventManagementSystem.repository;

import com.spring.EventManagementSystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<Users, Long> {

    Users findByemail(String username);


}
