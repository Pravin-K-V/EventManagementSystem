package com.spring.EventManagementSystem.security;

import com.spring.EventManagementSystem.entity.User;
import com.spring.EventManagementSystem.repository.UserJPARepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initUsers(UserJPARepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.count() == 0) {
                // Create an admin
                userRepository.save(
                        new User(
                                null,
                                "admin",            
                                "admin@example.com",
                                encoder.encode("admin123"), 
                                "12345",
                                "ROLE_ADMIN"        // role
                        )
                );
            }
        };
    }
}
