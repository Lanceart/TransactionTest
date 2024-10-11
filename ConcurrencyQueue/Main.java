package ConcurrencyQueue;

public class Main {
    public static void main(String[] args) {
        // SharedResource sharedResource = new SharedResource();

        // Thread producer = new Thread(() -> {
        //     for (int i = 1; i <= 100; i++) {
        //         sharedResource.produce(i);
        //     }
        // });

        // Thread consumer = new Thread(() -> {
        //     for (int i = 1; i <= 100; i++) {
        //         sharedResource.consume();
        //     }
        // });

        // producer.start();
        // consumer.start();


        SharedObject sharedObject = new SharedObject();
        Thread producer1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                sharedObject.produce(i);
            }
        });

        Thread consumer1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                sharedObject.consume();
            }
        });

        producer1.start();
        consumer1.start();
    }
}
