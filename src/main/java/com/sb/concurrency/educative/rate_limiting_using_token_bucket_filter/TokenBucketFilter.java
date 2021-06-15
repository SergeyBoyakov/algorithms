package com.sb.concurrency.educative.rate_limiting_using_token_bucket_filter;

public class TokenBucketFilter {
    private int MAX_TOKENS; // max amount of tokens possible in the bucket

    private long lastRequestTime = System.currentTimeMillis(); // var to note down the latest token request
    long possibleTokens = 0; // currently AVAILABLE tokens

    public TokenBucketFilter(final int maxTokens) {
        MAX_TOKENS = maxTokens;
    }

    synchronized void getToken() throws InterruptedException {
        // Divide by a 1_000 to transform millis -> seconds (cuz we have + 1 token per second in bucket)
        possibleTokens += (System.currentTimeMillis() - lastRequestTime) / 1000;
        if (possibleTokens > MAX_TOKENS) {
            possibleTokens = MAX_TOKENS;
        }

        if (possibleTokens == 0) {
            Thread.sleep(1_000);
        } else {
            possibleTokens--;
        }

        lastRequestTime = System.currentTimeMillis();

        logTokenGranting();
    }

    private void logTokenGranting() {
        System.out.println("Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis() / 1_000));
    }
}
