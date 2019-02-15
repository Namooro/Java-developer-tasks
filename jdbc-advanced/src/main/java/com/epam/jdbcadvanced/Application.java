package com.epam.jdbcadvanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

public class Application implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {

    }
}
