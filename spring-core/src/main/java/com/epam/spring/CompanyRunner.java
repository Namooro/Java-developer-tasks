package com.epam.spring;

import com.epam.spring.config.AppConfig;
import com.epam.spring.model.Employee;
import com.epam.spring.model.Position;
import com.epam.spring.model.enums.Department;
import com.epam.spring.service.EmployeeService;
import com.epam.spring.service.util.RandomGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CompanyRunner {

    private EmployeeService employeeService;
    private RandomGenerator randomGenerator;

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


    public void test() {

        employeeService = context.getBean(EmployeeService.class);

        Employee employee = new Employee("Java Developerov", getRandomExperience(), getRandomCity());
        employeeService.hireEmployee(employee, new Position("Java Developer", Department.DEVELOPMENT));

        employee = new Employee("Sharpov", getRandomExperience(), getRandomCity());
        employeeService.hireEmployee(employee, new Position(".Net Developer", Department.DEVELOPMENT));

        employee = new Employee("Managerin", getRandomExperience(), getRandomCity());
        employeeService.hireEmployee(employee, new Position("PM", Department.MANAGEMENT));

        employee = new Employee("Testerko", getRandomExperience(), getRandomCity());
        employeeService.hireEmployee(employee, new Position("QA Auto", Department.QA));

        employee = new Employee("Java Developerinm", getRandomExperience(), getRandomCity());
        employeeService.hireEmployee(employee, new Position("Java Developer", Department.DEVELOPMENT));

        employeeService.fireEmployee(employee);

        ((AnnotationConfigApplicationContext) context).close();
    }

    private Integer getRandomExperience() {
        randomGenerator = context.getBean(RandomGenerator.class);
        return randomGenerator.getRandomExperience();
    }

    private String getRandomCity() {
        randomGenerator = context.getBean(RandomGenerator.class);
        return randomGenerator.getRandomCity();
    }
}
