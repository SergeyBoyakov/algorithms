package com.sb.concurrency.educative.blocking_queue_synchronized;

public class Demonstration {
    public void main(String[] args) throws Exception {
        final BlockingQueue<Integer> q = new BlockingQueue<Integer>(5);

        Thread t1 = new Thread(() -> addIntegersToQueue(q, 50, "1"));

        Thread t2 = new Thread(() -> addIntegersToQueue(q, 25, "2"));

        Thread t3 = new Thread(() -> addIntegersToQueue(q, 25, "3"));

        t1.start();
        Thread.sleep(4_000);
        t2.start();

        t2.join();
        t3.start();
        t1.join();
        t3.join();
    }

    private void addIntegersToQueue(final BlockingQueue<Integer> queue, final int iterationAmount, final String threadName) {
        try {
            for (int i = 0; i < iterationAmount; i++) {
                queue.enqueue(i);
                log("enqueued " + i);
            }
        } catch (InterruptedException ie) {
            log("Thread " + threadName + " interrupted");
            Thread.currentThread().interrupt();
        }
    }

    private static void log(final String message) {
        System.out.println(message);
    }
}
