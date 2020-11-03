package com.sb.concurrency.hexlet;

public class ThreadHelper {

    public static void startAndJoinThread(final Thread thread) throws Exception {
        thread.start();
        thread.join();
    }
}
