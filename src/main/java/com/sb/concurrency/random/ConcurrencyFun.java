package com.sb.concurrency.random;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyFun {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread first = getThread();
        Thread second = getThread();
        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println("Counter = " + counter);
    }

    private static Thread getThread() {
        return new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter.incrementAndGet();
            }
        });
    }
}
