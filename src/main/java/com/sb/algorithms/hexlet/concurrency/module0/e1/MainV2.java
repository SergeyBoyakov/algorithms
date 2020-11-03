package com.sb.algorithms.hexlet.concurrency.module0.e1;

import com.sb.algorithms.hexlet.concurrency.module0.MockLoader;

public class MainV2 {
    public static void main(String[] args) throws InterruptedException {
        final long before = System.currentTimeMillis();
        ThreadLoaderRunnable test = new ThreadLoaderRunnable(new MockLoader("test"));
        Thread thread = new Thread(test);
        thread.start();
        thread.join();
        final long after = System.currentTimeMillis();
        System.out.printf("Delta = %d", (after - before) / 1_000);
    }
}
