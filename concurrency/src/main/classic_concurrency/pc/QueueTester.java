package classic_concurrency.pc;

public class QueueTester {

    public static void main(String[] args) throws InterruptedException {

        final MessageQueue messageQueue = new MessageQueue();

        Thread producerThread = new Thread(() -> {
            try {
                messageQueue.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread secondProducerThread = new Thread(() -> {
            try {
                messageQueue.secondProducer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                messageQueue.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread secondConsumerThread = new Thread(() -> {
            try {
                messageQueue.secondConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
        secondConsumerThread.start();
        secondProducerThread.start();

        producerThread.join();
        secondConsumerThread.join();
        secondProducerThread.join();
        consumerThread.join();
    }
}
