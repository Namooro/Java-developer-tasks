package com.epam.spring.model;

import com.epam.spring.model.enums.Department;

import java.util.Objects;

public class Position {

    private String title;
    private Department department;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position(String title, Department department) {
        this.title = title;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Position position = (Position) o;
        return Objects.equals(title, position.title) &&
                department == position.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, department);
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", department=" + department +
                '}';
    }
}
