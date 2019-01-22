package com.epam.estate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.epam.estate"})
@EntityScan("com.epam.estate.model")
@EnableJpaRepositories("com.epam.estate.repository")
public class EstateApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstateApplication.class, args);
    }

}