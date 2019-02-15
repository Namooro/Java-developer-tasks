package com.epam.spring.config;

import com.epam.spring.service.EmployeeService;
import com.epam.spring.service.PositionService;
import com.epam.spring.service.SalaryService;
import com.epam.spring.util.RandomStringAnnotationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.epam.spring.service")
public class AppConfig {

    @Bean
    public SalaryService salaryService() {
        return new SalaryService();
    }

    @Bean
    public PositionService positionService() {
        return new PositionService();
    }

    @Bean
    public EmployeeService employeeService(PositionService positionService, SalaryService salaryService) {
        EmployeeService employeeService = new EmployeeService(positionService);
        employeeService.setSalaryService(salaryService);
        return employeeService;
    }

    @Bean
    public RandomStringAnnotationInitializer randomStringAnnotationInitializer(){
        return new RandomStringAnnotationInitializer();
    }
}
