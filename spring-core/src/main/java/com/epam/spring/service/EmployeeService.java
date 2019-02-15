package com.epam.spring.service;

import com.epam.spring.data.CompanyInformation;
import com.epam.spring.model.Employee;
import com.epam.spring.model.Position;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import static java.lang.String.format;

public class EmployeeService implements CompanyService {

    private static final String SERVICE_NAME = "EmployeeService";

    private static final Logger log = Logger.getLogger(EmployeeService.class);

    private PositionService positionService;

    private SalaryService salaryService;

    public EmployeeService(PositionService positionService) {
        this.positionService = positionService;
    }

    @Required
    public void setSalaryService(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    public void hireEmployee(Employee employee, Position position) {
        if (!positionService.getAll().contains(position)) {
            positionService.add(position);
        }
        employee.setPosition(position);
        employee.setDepartment(position.getDepartment());
        employee.setEmployeeLevel(salaryService.determineEmployeeLevel(employee.getExperience()));
        employee.setSalary(salaryService.calculateSalaryByEmployeeLevel(employee.getDepartment(), employee.getEmployeeLevel()));
        CompanyInformation.employees.add(employee);
        log.info(format("%s was hired", employee));
        recalculateStatisticAndLogInformation(employee);
    }

    public void fireEmployee(Employee employee) {
        log.info(format("%s was fired", employee));
        CompanyInformation.employees.remove(employee);
        recalculateStatisticAndLogInformation(employee);
    }

    private void recalculateStatisticAndLogInformation(Employee employee) {
        salaryService.reCalculateAverageSalaryByDepartment(employee.getDepartment());
        log.info(format("Average salary for department %s: %s", employee.getDepartment(),
                CompanyInformation.departmentSalaryMap.get(employee.getDepartment())));
    }

    @Override
    public String getName() {
        return SERVICE_NAME;
    }
}
