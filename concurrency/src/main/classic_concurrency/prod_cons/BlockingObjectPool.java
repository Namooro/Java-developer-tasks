package classic_concurrency.prod_cons;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Pool that block when it has not any items or it full
 */

public class BlockingObjectPool {
    private final List<Object> pool;
    private final ReentrantLock lock = new ReentrantLock();
    private AtomicInteger createdObjects = new AtomicInteger(0);
    private AtomicInteger size;

    /**
     * Creates filled pool of passed size
     *
     * @param size of pool
     */
    public BlockingObjectPool(int size) {
        pool = new ArrayList<>(size);
        this.size = new AtomicInteger(size);
    }

    /**
     * Gets object from pool or blocks if pool is empty
     *
     * @return object from pool
     */
    public Object get() {
        Object result = null;
        try {
            lock.lock();
            if (!pool.isEmpty()) {
                result = pool.remove(0);
                System.out.println("Extracted object of class: " + result.getClass().getSimpleName());
                System.out.println("There are %n elements in pool: " + createdObjects.decrementAndGet());
            }
        } finally {
            lock.unlock();
        }
        return result;
    }

    /**
     * Puts object to pool or blocks if pool is full
     *
     * @param object to be taken back to pool
     */
    public void take(Object object) {
        try {
            lock.lock();
            if (createdObjects.intValue() < size.intValue()) {
                pool.add(object);
                System.out.println("Put object of class: " + object.getClass().getSimpleName());
                System.out.println("There are %n elements in pool: " + createdObjects.incrementAndGet());
            }
        } finally {
            lock.unlock();
        }
    }
}