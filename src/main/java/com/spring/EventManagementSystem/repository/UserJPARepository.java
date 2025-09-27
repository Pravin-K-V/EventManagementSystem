package com.spring.EventManagementSystem.repository;

import com.spring.EventManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {

    User findByemail(String username);

}
