package com.epam.jdbcadvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.epam.jdbcadvanced.model")
@SpringBootApplication
public class JdbcAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcAdvancedApplication.class, args);
    }

}

