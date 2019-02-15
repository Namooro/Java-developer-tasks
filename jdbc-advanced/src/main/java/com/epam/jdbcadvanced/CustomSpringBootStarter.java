package com.epam.jdbcadvanced;

import com.epam.jdbcadvanced.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.epam.jdbcadvanced.repository")
@ConditionalOnBean(UserRepository.class)
public class CustomSpringBootStarter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfigurableApplicationContext context;

    @Bean
    public void myCondtion() {
        if (userRepository.findAll().size() == 0) {
            SpringApplication.exit(context, (ExitCodeGenerator) () -> 42);
        }
    }

}
