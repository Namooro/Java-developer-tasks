package classic_concurrency.pc;

import java.util.LinkedList;
import java.util.List;

public class QueueTester {


    public static void main(String[] args) throws InterruptedException {

        List<String> queue = new LinkedList<>();
        Consumer consumer = new Consumer();
        Producer producer = new Producer();

        producer.produce(queue, 1);
        producer.produce(queue, 2);
        producer.produce(queue, 2);
        producer.produce(queue, 1);
        producer.produce(queue, 2);
        consumer.consume(queue, 1);
        consumer.consume(queue, 2);
    }
}
