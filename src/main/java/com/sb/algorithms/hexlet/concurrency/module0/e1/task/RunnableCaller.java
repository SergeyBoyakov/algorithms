package com.sb.algorithms.hexlet.concurrency.module0.e1.task;

public class RunnableCaller {
    public int getResultFromSumRunnable(final int[] input) throws InterruptedException {
        SumRunnable sumRunnable = new SumRunnable(input);
        Thread thread = new Thread(sumRunnable);
        thread.start();
        thread.join();

        return sumRunnable.getResult();
    }
}
