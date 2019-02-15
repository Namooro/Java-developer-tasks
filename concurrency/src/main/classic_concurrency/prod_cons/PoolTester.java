package classic_concurrency.prod_cons;



public class PoolTester {

    public static void main(String[] args) throws InterruptedException {
        BlockingObjectPool pool = new BlockingObjectPool(10);

        Thread insertingFirstThread = new Thread(() -> {
            while (true) {
                pool.take("String");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread insertingSecondThread = new Thread(() -> {
            while (true) {
                pool.take(5);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread insertingThirdThread = new Thread(() -> {
            while (true){
                pool.take(1L);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread extractingThread = new Thread(() -> {
            while (true){
                try {
                    pool.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        extractingThread.start();
        insertingFirstThread.start();
        insertingSecondThread.start();
        insertingThirdThread.start();

        extractingThread.join();
        insertingFirstThread.join();
        insertingSecondThread.join();
        insertingThirdThread.join();

    }
}
