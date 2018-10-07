package first_homework.bit_of_concurrency;

import first_homework.bit_of_concurrency.beans.SomeBusinessTaskImplementation;

public class App {

    public static void main(String... args) {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    new SomeBusinessTaskImplementation().someLogic();
                    Thread.sleep(1000);
                    System.out.println("Time checking");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        executeTask(task);
        executeTask(task);
    }

    private static void executeTask(Runnable threadLogic) {
        new Thread(threadLogic).start();
    }
}