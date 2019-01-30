package classic_concurrency.pc;

import java.util.List;

public class Producer {
    private int capacity = 5;

    public void produce(List<String> queue, int topic) throws InterruptedException {
        Thread thread = new  Thread(() -> {
            try {
                while (true) {
                    synchronized (queue) {
                        while (queue.size() == capacity) {
                            queue.wait();
                        }
                        queue.add("topic " + topic);
                        System.out.println(topic + "nd Producer produced - topic " + topic);
                        queue.notifyAll();
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join(100);
    }
}
