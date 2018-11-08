package tests;

import first_homework.mathcollector_for_int_stream.Seventh_Task;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


public class MathCollectorTest {


    @Test
    public void checkAverage() {
        Stream<Integer> myStreamAverage = Stream.iterate(1, i -> i + 1).limit(10);
        assertEquals(myStreamAverage.collect(new Seventh_Task.MathCollector()).getAverage(), 5.0, Double.MIN_VALUE);
    }

    @Test
    public void checkSum() {
        Stream<Integer> myStreamSum = Stream.iterate(100, i -> i + 100).limit(9);
        assertEquals(myStreamSum.collect(new Seventh_Task.MathCollector()).getSum(), 4500, Double.MIN_VALUE);
    }
}
