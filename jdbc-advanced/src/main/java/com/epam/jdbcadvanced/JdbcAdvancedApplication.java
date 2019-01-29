package com.epam.jdbcadvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.epam.jdbcadvanced.model")
@ComponentScan({"com.epam.jdbcadvanced"})
@EnableJpaRepositories("com.epam.jdbcadvanced.repository")
@SpringBootApplication
public class JdbcAdvancedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcAdvancedApplication.class, args);
    }

}

