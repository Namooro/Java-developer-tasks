package first_homework.mathcollector_for_int_stream;

import first_homework.mathcollector_for_int_stream.beans.Statistics;

import java.util.EnumSet;
import java.util.Set;
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
        Stream<Integer> randomStream = Stream.iterate(1, i -> i + 1)
                .parallel()
                .limit(500000)
                .unordered();
        long startTime = System.currentTimeMillis();
        System.out.println(randomStream.collect(new MathCollector()));
        System.out.println(System.currentTimeMillis() - startTime);

    }

    public static class MathCollector implements Collector<Integer, Statistics, Statistics> {

        @Override
        public Supplier<Statistics> supplier() {
            return Statistics::new;
        }

        @Override
        public synchronized BiConsumer<Statistics, Integer> accumulator() {
            return (newStats, number) -> {
                newStats.updateCount();
                newStats.setMax(Math.max(number, newStats.getMax().get()));
                newStats.setMin(Math.min(number, newStats.getMin()));
                newStats.setSum(newStats.getSum().addAndGet(number));
                newStats.setAverage(newStats.getSum().get() / (double) newStats.getCount().get());
            };
        }

        @Override
        public BinaryOperator<Statistics> combiner() {
            return (statistics, statistics2) -> {
                statistics.setCount(statistics.getCount().accumulateAndGet(statistics2.getCount().get(), Math::addExact));
                statistics.setMax(statistics.getMax().accumulateAndGet(statistics2.getMax().get(), Math::min));
                statistics.setMin(Math.min(statistics.getMin(), statistics2.getMin()));
                statistics.getSum().accumulateAndGet(statistics2.getSum().get(), Math::addExact);
                statistics.setAverage(statistics.getSum().accumulateAndGet(statistics2.getCount().get(), Math::floorDiv));
                return statistics;
            };
        }

        @Override
        public Function<Statistics, Statistics> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT);
        }
    }
}
