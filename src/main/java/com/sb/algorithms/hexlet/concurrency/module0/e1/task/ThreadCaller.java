package com.sb.algorithms.hexlet.concurrency.module0.e1.task;

public class ThreadCaller {

    public int getResultFromSumThread(final int[] input) throws InterruptedException {
        SumThread sumThread = new SumThread(input);
        sumThread.start();
        sumThread.join();

        return sumThread.getResult();
    }
}
