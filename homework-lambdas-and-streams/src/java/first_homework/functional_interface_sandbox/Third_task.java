package first_homework.functional_interface_sandbox;

import first_homework.a_person_stream.beans.Person;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Third_task {
    public static void main(String[] args) {

        Predicate<LocalDate> isPrime = Third_task::isSundayToday;

        Consumer<DayOfWeek> weekDayConsumer = weekDay -> System.out.println("Winnie Pooh's message is " + weekDay);

        Function<String, Person> strangeConstructor = name -> new Person(name, 13);

        Function<Integer, Integer> addOne = a -> a + 1;

        System.out.println(addOne.apply(1));

        Supplier<Boolean> random = () -> ThreadLocalRandom.current().nextBoolean();

        System.out.println(random.get());

     //   Arrays.asList(1, 2, 3, 4, 5).stream().map(addOne).filter(isPrime).forEach(messageConsumer);
    }

    private static boolean isSundayToday(LocalDate date) {
        return DayOfWeek.SUNDAY.equals(date.getDayOfWeek());
    }
}
