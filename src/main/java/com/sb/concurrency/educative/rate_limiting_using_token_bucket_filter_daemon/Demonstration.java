package com.sb.concurrency.educative.rate_limiting_using_token_bucket_filter_daemon;

import java.util.HashSet;
import java.util.Set;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        Set<Thread> allThreads = new HashSet<>();
        final MultithreadedTokenBucketFilter tokenBucketFilter = new MultithreadedTokenBucketFilter(1);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                try {
                    tokenBucketFilter.getToken();
                } catch (InterruptedException ie) {
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
