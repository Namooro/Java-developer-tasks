package com.epam.spring.data;

import com.epam.spring.model.Employee;
import com.epam.spring.model.Position;
import com.epam.spring.model.enums.Department;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CompanyInformation {

    public static List<Employee> employees = new LinkedList<>();

    public static List<Position> positions = new LinkedList<>();

    public static Map<Department, Long> departmentSalaryMap = new HashMap<>();

}
