package classic_concurrency.pc;

import java.util.LinkedList;
import java.util.List;

public class MessageQueue {

    private List<String> queue = new LinkedList<>();
    private int capacity = 5;

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == capacity) {
                    wait();
                }
                queue.add("topic 1");

                System.out.println("Producer produced - topic 1");

                notify();
            }
            Thread.sleep(100);
        }
    }

    public void secondProducer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == capacity) {
                    wait();
                }
                queue.add("topic 2");

                System.out.println("2nd Producer produced - topic 2");

                notify();
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }
                if (queue.get(0).contains("topic 1")) {
                    queue.remove(0);
                }

                System.out.println("Consumer consumed - topic 1");
                notify();

            }
            Thread.sleep(100);
        }
    }

    public void secondConsumer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }
                if (queue.get(0).contains("topic 2")) {
                    queue.remove(0);
                }

                System.out.println("2nd Consumer consumed - topic 2");
                notify();

            }
            Thread.sleep(1000);
        }
    }
}

