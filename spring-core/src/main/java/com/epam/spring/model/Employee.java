package com.epam.spring.model;

import com.epam.spring.model.enums.Department;
import com.epam.spring.model.enums.EmployeeLevel;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Employee {


    private String name;

    private Position position;

    @Min(10000)
    @Max(200000)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Integer salary;

    private String city;

    @Min(0)
    @Max(10)
    private Integer experience;

    private EmployeeLevel employeeLevel;
    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public EmployeeLevel getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(EmployeeLevel employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(String name, int experience, String city) {
        this.name = name;
        this.experience = experience;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }
}
