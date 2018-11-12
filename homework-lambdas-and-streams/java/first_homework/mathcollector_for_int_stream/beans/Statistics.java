package first_homework.mathcollector_for_int_stream.beans;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Statistics {

    private AtomicInteger max = new AtomicInteger(0);
    private int min;
    private AtomicLong count = new AtomicLong(0);
    private AtomicLong sum = new AtomicLong(0);
    private double average;

    public void setCount(Long count) {
        this.count.getAndSet(count);
    }

    public synchronized AtomicLong getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum.set(sum);
    }

    public synchronized AtomicInteger getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max.set(max);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public AtomicLong getCount() {
        return count;
    }

    public void updateCount() {
        count.incrementAndGet();
    }

    public double getAverage() {
        return average;
    }

    public synchronized void setAverage(double average) {
        this.average = average;
    }

    public Statistics() {
        this.average = 0;
        this.count = new AtomicLong(0);
        this.sum = new AtomicLong(0);
        this.max = new AtomicInteger(0);
        this.min = Integer.MAX_VALUE;
    }

    public Statistics(int max, int min, long count, long sum, double average) {
        this.max.set(max);
        this.min = min;
        this.sum.set(sum);
        this.count.set(count);
        this.average = average;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "max=" + max +
                ", min=" + min +
                ",sum=" + sum +
                ", count=" + count +
                ", average=" + average +
                '}';
    }
}
