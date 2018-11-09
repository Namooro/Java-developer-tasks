package tests;

import first_homework.custom_collector.Sixth_Task;
import first_homework.custom_collector.beans.Student;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectorTest {

    @Test
    public void studentNotGraduated() {
        List<Student> studentList = Collections.singletonList(
                new Student("SecondTestStudent", 25, LocalDate.now(), 3));
        assertEquals(studentList.stream()
                .collect(new Sixth_Task.StudentCollector()
                ).indexOf("graduated=true"), -1);
    }
}
