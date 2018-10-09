package first_homework.functional_interface_sandbox;

import first_homework.a_person_stream.Second_Task;
import first_homework.a_person_stream.beans.Person;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Third_task {
    public static void main(String[] args) {

        Predicate<Integer> isAdult = Third_task::moreThan21;

        Consumer<Integer> pesonNameConsumer = age -> System.out.println("Adult ages: " + age);

        Function<String, Person> strangeConstructor = name -> new Person(name, 13);

        Function<LocalDate, LocalDate> tomorrowDay = date -> date.plusDays(1);

        System.out.println(tomorrowDay.apply(LocalDate.now()));

        Supplier<Boolean> random = () -> ThreadLocalRandom.current().nextBoolean();

        System.out.println(strangeConstructor.apply("new Person name"));

        Second_Task.getListOfPersons().stream()
                .map(Person::getAge)
                .filter(isAdult)
                .forEach(pesonNameConsumer);
    }

    private static boolean moreThan21(Integer age) {
        return age > 21;
    }
}
