package first_homework.bit_of_concurrency;

import first_homework.bit_of_concurrency.beans.SomeBusinessTaskImplementation;

public class First_Task {
    /**
     * This task shows different instance of Runnable interface
     * with different behaviour
     */
    public static void main(String... args) {

        Runnable task = () -> {
            new SomeBusinessTaskImplementation().someLogic();
            System.out.println("Time checking");

        };
        Runnable differentTask = () -> {
            try {
                new SomeBusinessTaskImplementation().someOtherLogic();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        };
        for (int i = 0; i < 5; i++) {
            executeTask(task);
            executeTask(differentTask);
        }
    }

    private static void executeTask(Runnable threadLogic) {
        new Thread(threadLogic).start();
    }
}