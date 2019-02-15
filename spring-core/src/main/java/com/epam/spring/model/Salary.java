package com.epam.spring.model;

public class Salary {

    private int annualSalary;

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Salary(int annualSalary) {
        this.annualSalary = annualSalary;
    }
}
