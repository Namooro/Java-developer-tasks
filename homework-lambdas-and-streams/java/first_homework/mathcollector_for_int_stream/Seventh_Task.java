package first_homework.mathcollector_for_int_stream;

import first_homework.mathcollector_for_int_stream.beans.Statistics;

import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Seventh_Task {
    /**
     * This task calculate statistics of huge amount of randomized numbers
     * via custom MathCollector class
     */
    public static void main(String[] args) {
        Stream<Integer> randomStream = Stream.iterate(1, i -> i <= 500000, i -> i + ThreadLocalRandom.current()
                .nextInt(1, 50))
                .parallel()
                .unordered();
        System.out.println(randomStream.collect(new MathCollector()));

    }

    public static class MathCollector implements Collector<Integer, Statistics, Statistics> {

        @Override
        public Supplier<Statistics> supplier() {
            return Statistics::new;
        }

        @Override
        public BiConsumer<Statistics, Integer> accumulator() {
            return (newStats, number) ->
            {
                newStats.updateCount();
                newStats.setMax(Math.max(number, newStats.getMax()));
                newStats.setMin(Math.min(number, newStats.getMin()));
                newStats.setSum(newStats.getSum() + number);
                newStats.setAverage(newStats.getSum() / newStats.getCount());
            };
        }

        @Override
        public BinaryOperator<Statistics> combiner() {
            return (statistics, statistics2) -> statistics;
        }

        @Override
        public Function<Statistics, Statistics> finisher() {
            return statistics -> statistics;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return EnumSet.of(Characteristics.CONCURRENT, Characteristics.UNORDERED);
        }

    }
}
