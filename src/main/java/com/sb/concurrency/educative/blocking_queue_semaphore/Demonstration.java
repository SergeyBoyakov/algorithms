package com.sb.concurrency.educative.blocking_queue_semaphore;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        final BlockingQueueWithSemaphore<Integer> q = new BlockingQueueWithSemaphore<>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    q.enqueue(new Integer(i));
                    System.out.println("enqueue " + i);
                }
            } catch (InterruptedException ie) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 2 dequeued: " + q.dequeue());
                }
            } catch (InterruptedException ie) {
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread 3 dequeued: " + q.dequeue());
                }
            } catch (InterruptedException ie) {

            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();
        t2.join();

        t3.start();
        t1.join();
        t3.join();
    }
}
