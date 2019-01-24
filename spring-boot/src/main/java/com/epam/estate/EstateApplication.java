package com.epam.estate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"com.epam.estate"})
@EntityScan("com.epam.estate.model")
@EnableJpaRepositories("com.epam.estate.repository")
public class EstateApplication {

    @ConfigurationProperties(prefix = "spring.datasource")

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("sa")
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:Estate;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;")
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(EstateApplication.class, args);
    }
}