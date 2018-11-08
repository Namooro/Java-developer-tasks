package tests;

import first_homework.mathcollector_for_int_stream.Seventh_Task;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


public class MathCollectorTest {

    @Test
    public void checkAverage() {
        Stream<Integer> myStreamAverage = Stream.iterate(1, i -> i <= 10, i -> i + 1);
        assertEquals(5.0, myStreamAverage.collect(new Seventh_Task.MathCollector()).getAverage(), Double.MIN_VALUE);
    }

    @Test
    public void checkSum() {
        Stream<Integer> myStreamSum = Stream.iterate(100, i -> i <= 1000, i -> i + 100);
        assertEquals(5500, myStreamSum.collect(new Seventh_Task.MathCollector()).getSum(), Double.MIN_VALUE);
    }
}
