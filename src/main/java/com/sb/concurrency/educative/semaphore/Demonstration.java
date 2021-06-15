package com.sb.concurrency.educative.semaphore;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        final CountingSemaphore semaphore = new CountingSemaphore(1);

        Thread firstThread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    semaphore.acquire();
                    System.out.println();
                    System.out.printf("Semaphore acquired: %d ", i);
                    System.out.println();
                }
            } catch (InterruptedException e) {
                // noop
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    semaphore.release();
                    System.out.println();
                    System.out.printf("Semaphore released: %d", i);
                    System.out.println();
                } catch (InterruptedException e) {
                    // noop
                }
            }
        });

        secondThread.start();
        firstThread.start();
        firstThread.join();
        secondThread.join();
    }
}
