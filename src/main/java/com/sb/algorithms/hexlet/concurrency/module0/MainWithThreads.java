package com.sb.algorithms.hexlet.concurrency.module0;

public class MainWithThreads {
    public static void main(String[] args) throws InterruptedException {
        final MockLoader loadFromFile = new MockLoader("loadFromFile");
        final MockLoader loadFromWeb = new MockLoader("loadFromWeb");
        final long before = System.currentTimeMillis();

        final Thread fileTextLoaderThread = new Thread(() -> System.out.println(loadFromFile.loadText()));
        fileTextLoaderThread.start();

        final Thread webTextLoaderThread = new Thread(() -> System.out.println(loadFromWeb.loadText()));
        webTextLoaderThread.start();

        fileTextLoaderThread.join();
        webTextLoaderThread.join();

        final long after = System.currentTimeMillis();

        System.out.printf("time delta: %d\n", (after - before) / 1_000);
    }
}
