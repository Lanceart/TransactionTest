package ConcurrencyQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
class SharedResource {
    private Queue<Integer> data = new LinkedList<Integer>();
    private int available = 0;
    private Random random =  new Random();
    
    public synchronized void produce(int value) {
        while (available == 10) {
            try {
                wait(); // 如果资源可用，生产者等待
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data.add(value);
        available += 1;


        try{
            Thread.sleep((int) (Math.random() * 100));
        }catch(Exception e){
            
        }
        System.out.println("Produced: " + value);
        notify(); // 通知消费者
    }

    public synchronized void consume() {
        while (available == 0) {
            try {
                wait(); // 如果资源不可用，消费者等待
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available --;
        try{
            Thread.sleep((int) (Math.random() * 100));
        }catch(Exception e){
            
        }
        System.out.println("Consumed: " + data.poll());
        notify(); // 通知生产者
    }
}