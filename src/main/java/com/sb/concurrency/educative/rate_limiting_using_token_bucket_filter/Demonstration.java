package com.sb.concurrency.educative.rate_limiting_using_token_bucket_filter;

import java.util.HashSet;
import java.util.Set;

public class Demonstration {

    public static void main(String[] args) throws InterruptedException {
        runTestMaxTokenIsTen();
    }

    private static void runTestMaxTokenIsTen() throws InterruptedException {
        Set<Thread> allThreads = new HashSet<>();

        final TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(5);

        // Sleep for 10 seconds
        Thread.sleep(10_000);

        // Generate 12 threads requesting tokens almost all at once
        for (int i = 0; i < 12; i++) {
            Thread thread = new Thread(()->{
                try {
                    tokenBucketFilter.getToken();
                } catch (InterruptedException interruptedException) {
                    System.out.println("We have a problem");
                }
            });

            thread.setName("Thread_" + (i+1));
            allThreads.add(thread);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }
}
