package com.sb.concurrency.educative.rate_limiting_using_token_bucket_filter_daemon;

public class MultithreadedTokenBucketFilter {
    private long possibleTokens = 0; // amount of tokens, which can be used by consumer thread, current amount of tokens
    private final int MAX_TOKENS;
    private final int ONE_SECOND_MILLIS = 1000;

    public MultithreadedTokenBucketFilter(int maxTokens) {
        this.MAX_TOKENS = maxTokens;

        // Never start a thread in a constructor
        Thread dt = new Thread(() -> {
            daemonThread();
        });
        dt.setDaemon(true);
        dt.start();
    }

    // should add token to bucket every second
    private void daemonThread() {
        while (true) {
            synchronized (this) { // same bock as in getToken
                if (possibleTokens < MAX_TOKENS) {
                    possibleTokens++;
                }
                this.notify();
            }
            try {
                Thread.sleep(ONE_SECOND_MILLIS);
            } catch (InterruptedException ie) {
                // noOp
            }
        }
    }

    void getToken() throws InterruptedException {
        synchronized (this) {
            while (possibleTokens == 0) { // shared mutable object possibleTokens is in sync block
                this.wait();
            }
            possibleTokens--;
        }

        logTokenGranting();
    }

    private void logTokenGranting() {
        System.out.println("Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1_000);
    }
}
