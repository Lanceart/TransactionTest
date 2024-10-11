package ConcurrencyQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObject {
    private final int MAX_CAPACITY = 10;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int value) {
        lock.lock();
        try {
            while (queue.size() == MAX_CAPACITY) {
                System.out.println("Queue is full, producer waiting...");
                notFull.await(); // 队列满时，生产者等待
            }
            queue.offer(value);
            System.out.println("Produced: " + value);
            notEmpty.signal(); // 通知消费者队列不空了
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Queue is empty, consumer waiting...");
                notEmpty.await(); // 队列空时，消费者等待
            }
            int value = queue.poll();
            System.out.println("Consumed: " + value);
            notFull.signal(); // 通知生产者队列有空位了
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
