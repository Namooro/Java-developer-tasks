package first_homework.functional_interface_sandbox;

import first_homework.a_person_stream.Second_Task;
import first_homework.a_person_stream.beans.Person;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Third_Task {
    /**
     * This task implements functional interfaces and one custom one
     */
    public static void main(String[] args) {


        Predicate<Integer> isAdult = Third_Task::moreThan21;

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

        Inverse inverse = (x) -> new StringBuilder(x).reverse().toString();
        System.out.println(inverse.run("Hello"));

        System.out.println(Inverse1.staticMethod());
        Inverse1.anotherStatic();

        Inverse1 inverse1 = (x) -> new StringBuilder().reverse().toString();
        System.out.println(inverse1.run("lower case"));
    }

    private static boolean moreThan21(Integer age) {
        return age > 21;
    }

    @FunctionalInterface
    interface Inverse {
        String run(String input);

        default String run() {
            return "empty default";
        }
    }

    @FunctionalInterface
    interface Inverse1 {
        String run(String input);

        static String staticMethod() {
            return "new default";
        }

        static void anotherStatic() {
            System.out.println("Another static");
        }

        default String run() {
            return "Another default";
        }
    }
}
