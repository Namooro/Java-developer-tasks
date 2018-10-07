package first_homework.a_person_stream;

import first_homework.a_person_stream.beans.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Second_Task {


    public static void main(String[] args) {
        List<Person> personList = getListOfPersons();
        personList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
        personList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }

    private static List<Person> getListOfPersons() {
        return Arrays.asList(
                new Person("firstPerson", 13),
                new Person("secondPerson", 21),
                new Person("thirdPerson", 49),
                new Person("fourthPerson", 47));
    }
}
