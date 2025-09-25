package com.spring.EventManagementSystem.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CSVDataLoader {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void loadCSVData(){

        String sql = "INSERT INTO users(name, email, password, phone_number, role, active)" + "SELECT * FROM CSVREAD('src/main/resources/data.csv')";
        jdbcTemplate.execute(sql);

    }

}
