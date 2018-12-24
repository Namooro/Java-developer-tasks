package classic_concurrency.pc;

import java.util.LinkedList;
import java.util.List;

public class MessageQueue {

    private List<String> queue = new LinkedList<>();
    private int capacity = 2;

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == capacity) {
                    wait();
                }
                queue.add("message");

                System.out.println("Producer produced - message");

                notify();

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0) {
                    wait();
                }
                queue.remove(0);

                System.out.println("Consumer consumed - message");
                notify();

                Thread.sleep(1000);
            }
        }
    }
}

