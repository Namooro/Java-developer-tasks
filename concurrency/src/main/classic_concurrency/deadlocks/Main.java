package classic_concurrency.deadlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> arrayList = new ArrayList<>();

        var t1 = new Thread(() -> {
            synchronized (arrayList) {
                for (int i = 0; i < 100; i++)
                    arrayList.add(ThreadLocalRandom.current().nextInt(0, 100));
            }
        }
        );

        var t2 = new Thread(() -> {
            synchronized (arrayList) {
                int total = arrayList.stream().mapToInt(Integer::intValue).sum();
                System.out.println(total);
            }
        });

        var t3 = new Thread(() -> {
            synchronized (arrayList) {
                int result = arrayList.stream().mapToInt(element -> element * element).sum();
                System.out.println(Math.sqrt(result));
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
