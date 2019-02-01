package com.epam.estate;

import com.epam.estate.repository.AgentRepository;
import com.epam.estate.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import(EstateApplication.class)
@ConditionalOnClass(EstateRepository.class)

public class CustomConfiguration {

    @Autowired
    AgentRepository agentRepository;

    @Autowired
    private ApplicationContext appContext;

    @Bean
    public void estateCodition() {
        if (agentRepository.findAll().size() < 100) {
            SpringApplication.exit(appContext, (ExitCodeGenerator) () -> 0);
        }
    }

}
