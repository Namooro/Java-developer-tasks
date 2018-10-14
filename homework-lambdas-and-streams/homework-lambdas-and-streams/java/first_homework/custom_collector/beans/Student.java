package first_homework.custom_collector.beans;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Student {

    private String name;
    private int age;
    private LocalDate birthday;
    private double grade;
    private boolean graduated = false;
    private long daysBeforeBirthday;

    public void setDaysBeforeBirthday(long daysBeforeBirthday) {
        this.daysBeforeBirthday = daysBeforeBirthday;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public Student(String name, int age, LocalDate birthday, double grade) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", grade=" + grade +
                ", graduated=" + graduated +
                ", daysBeforeBirthday=" + daysBeforeBirthday +
                '}';
    }

    public Long daysBeforeBirthday() {
        return DAYS.between(LocalDate.now(), this.getBirthday());
    }

    public Boolean classCompleted() {
        return this.getGrade() > 4.0;
    }
}
