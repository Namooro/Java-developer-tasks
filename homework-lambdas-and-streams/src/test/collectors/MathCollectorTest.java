package collectors;

import first_homework.mathcollector_for_int_stream.Seventh_Task;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


public class MathCollectorTest {

    @Test
    public void checkAverage() {
        Stream<Integer> myStreamAverage = Stream.iterate(1, i -> i + 1).limit(10).parallel().unordered();
        assertEquals(5.5, myStreamAverage.collect(new Seventh_Task.MathCollector()).getAverage(), Double.MIN_VALUE);
    }

    @Test
    public void checkSum() {
        Stream<Integer> myStreamSum = Stream.iterate(100, i -> i + 100).limit(10).parallel().unordered();
        assertEquals(5500, myStreamSum.collect(new Seventh_Task.MathCollector()).getSum().get());
    }

    @Test
    public void checkCount() {
        Stream<Integer> myStreamSum = Stream.iterate(100, i -> i + 100).parallel().unordered().limit(999999);
        assertEquals(999999, myStreamSum.collect(new Seventh_Task.MathCollector()).getCount().get());
    }

}
