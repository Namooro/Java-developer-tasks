package com.epam.spring.service;

import com.epam.spring.data.CompanyInformation;
import com.epam.spring.model.Employee;
import com.epam.spring.model.enums.Department;
import com.epam.spring.model.enums.EmployeeLevel;
import org.apache.log4j.Logger;

import java.util.stream.Collectors;

public class SalaryService implements CompanyService {

    private static final Logger log = Logger.getLogger(SalaryService.class);

    private static final String SERVICE_NAME = "EmployeeService";

    //Years of experience to calculate employee level
    private static final int JUNIOR_STAGE = 2;
    private static final int MIDDLE_STAGE = 5;

    //Salary by position
    private static final int DEVELOPER_ANNUAL_SALARY = 2000;
    private static final int QA_ANNUAL_SALARY = 1000;
    private static final int MANAGER_ANNUAL_SALARY = 1800;

    //Salary multiplier depending on the employee level
    private static final int JUNIOR_SALARY_MULTIPLIER = 1;
    private static final int MIDDLE_SALARY_MULTIPLIER = 2;
    private static final int SENIOR_SALARY_MULTIPLIER = 3;

    /**
     * Calculate average salary by department.
     *
     * @param department
     */
    public void reCalculateAverageSalaryByDepartment(Department department) {
        Integer numberOfEmployeesInDepartment = CompanyInformation.employees
                .stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList())
                .size();
        Long totalSalaryInDepartment = CompanyInformation.employees
                .stream()
                .filter(e -> e.getDepartment() == department)
                .mapToLong(Employee::getSalary)
                .sum();
        CompanyInformation.departmentSalaryMap.put(department, totalSalaryInDepartment / numberOfEmployeesInDepartment);
    }

    /**
     * Determines employee level based on experience.
     * This is later used to calculate salary multiplier depending on the employee level.
     */
    public EmployeeLevel determineEmployeeLevel(int experience) {
        if (experience <= JUNIOR_STAGE) {
            return EmployeeLevel.JUNIOR;
        } else {
            if (experience <= MIDDLE_STAGE) {
                return EmployeeLevel.MIDDLE;
            } else {
                return EmployeeLevel.SENIOR;
            }
        }
    }

    /**
     * Calculate salary value based on department and level.
     */
    public int calculateSalaryByEmployeeLevel(Department department, EmployeeLevel employeeLevel) {
        int salaryByDepartmentAndLevel = getDepartmentAnnualSalary(department);

        switch (employeeLevel) {
            case JUNIOR:
                salaryByDepartmentAndLevel = salaryByDepartmentAndLevel * JUNIOR_SALARY_MULTIPLIER;
                break;
            case MIDDLE:
                salaryByDepartmentAndLevel = salaryByDepartmentAndLevel * MIDDLE_SALARY_MULTIPLIER;
                break;
            case SENIOR:
                salaryByDepartmentAndLevel = salaryByDepartmentAndLevel * SENIOR_SALARY_MULTIPLIER;
                break;
            default:
                salaryByDepartmentAndLevel = salaryByDepartmentAndLevel * JUNIOR_SALARY_MULTIPLIER;
                break;
        }
        return salaryByDepartmentAndLevel;
    }

    /**
     * Get salary by department.
     */
    private int getDepartmentAnnualSalary(Department department) {
        int salary;
        switch (department) {
            case DEVELOPMENT:
                salary = DEVELOPER_ANNUAL_SALARY;
                break;
            case QA:
                salary = QA_ANNUAL_SALARY;
                break;
            case MANAGEMENT:
                salary = MANAGER_ANNUAL_SALARY;
                break;
            default:
                salary = QA_ANNUAL_SALARY;
                break;
        }
        return salary;
    }

    @Override
    public String getName() {
        return SERVICE_NAME;
    }
}
