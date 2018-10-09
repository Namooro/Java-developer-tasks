package first_homework.custom_collector;

import first_homework.custom_collector.beans.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Sixth_Task {
    public static void main(String[] args) {
        System.out.println(getListOfPersons().stream()
                .parallel()
                .unordered()
                .collect(new studentCollector()));
    }


    private static class studentCollector implements Collector<Student, List<Student>, String> {

        @Override
        public Supplier<List<Student>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<Student>, Student> accumulator() {
            return (studentList, student) ->
            {
                if (student.classCompleted()) {
                    student.setGraduated(true);
                }
                student.setDaysBeforeBirthday(student.daysBeforeBirthday());
                studentList.add(student);
            };

        }

        @Override
        public BinaryOperator<List<Student>> combiner() {
            return (studentList, studentList2) -> studentList;
        }

        @Override
        public Function<List<Student>, String> finisher() {
            return Object::toString;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return EnumSet.of(Characteristics.CONCURRENT, Characteristics.UNORDERED);
        }

    }

    public static List<Student> getListOfPersons() {
        return Arrays.asList(
                new Student("firstStudent", 23, LocalDate.now().minusDays(44), 4.4444),
                new Student("secondStudent", 21, LocalDate.now().minusDays(1), 4.3),
                new Student("thirdStudent", 19, LocalDate.now(), 4.5),
                new Student("fourthStudent", 25, LocalDate.now(), 4.9));
    }
}
