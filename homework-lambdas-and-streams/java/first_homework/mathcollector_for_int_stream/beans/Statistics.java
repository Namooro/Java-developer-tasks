package first_homework.mathcollector_for_int_stream.beans;

public class Statistics {

    private int max;
    private int min;
    private long count;
    private long sum;
    private double average;

    public void setCount(long count) {
        this.count = count;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public long getCount() {
        return count;
    }

    public synchronized void updateCount() {
        this.count += 1;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Statistics() {
        this.average = 0;
        this.count = 0;
        this.sum = 0;
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }

    public Statistics(int max, int min, long count, long sum, double average) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.count = count;
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
