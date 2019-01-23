package classic_concurrency.pc;

import java.util.List;

public class Consumer {

    public void consume(List<String> queue, int topic) throws InterruptedException {
       Thread thread =  new Thread(() -> {
            try {
                while (true) {
                    synchronized (this) {
                        while (queue.size() == 0) {
                            wait();
                        }
                        if (queue.get(0).contains("topic " + topic)) {
                            queue.remove(0);
                        }
                        System.out.println("Consumer consumed - topic " + topic);
                        notify();
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
       thread.start();
       thread.join(100);
    }
}