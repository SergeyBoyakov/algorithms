package com.sb.concurrency.educative.blocking_queue_mutex;

public class Demonstration {
    static final BlockingQueueWithMutex<Integer> q = new BlockingQueueWithMutex<>(5);

    public static void main(String[] args) throws InterruptedException {

        Thread producer1 = new Thread(() -> enqueueWithLogging("1", q));
        Thread producer2 = new Thread(() -> enqueueWithLogging("2", q));
        Thread producer3 = new Thread(() -> enqueueWithLogging("3", q));

        // consumers
        Thread firstConsumer = new Thread(() -> dequeueWithLogging("1", q));

        Thread secondConsumer = new Thread(() -> dequeueWithLogging("2", q));

        Thread thirdConsumer = new Thread(() -> dequeueWithLogging("3", q));

        producer1.setDaemon(true);
        producer2.setDaemon(true);
        producer3.setDaemon(true);

        firstConsumer.setDaemon(true);
        secondConsumer.setDaemon(true);
        thirdConsumer.setDaemon(true);

        producer1.start();
        producer2.start();
        producer3.start();

        firstConsumer.start();
        secondConsumer.start();
        thirdConsumer.start();

        Thread.sleep(1_000);
    }

    private static void dequeueWithLogging(final String consumerNumber, final BlockingQueueWithMutex<Integer> q) {
        try {
            while (true) {
                System.out.println("Consumer thread 1 dequeued " + q.dequeue());
            }
        } catch (InterruptedException interruptedException) {
            //noop
        }
    }

    private static void enqueueWithLogging(final String threadNumber, final BlockingQueueWithMutex<Integer> q) {
        try {
            int i = 1;
            while (true) {
                q.enqueue(i);
                System.out.println("Producer thread " + threadNumber + " enqueued " + i);
                i++;
            }
        } catch (InterruptedException ie) {
            //noop
        }
    }
}
