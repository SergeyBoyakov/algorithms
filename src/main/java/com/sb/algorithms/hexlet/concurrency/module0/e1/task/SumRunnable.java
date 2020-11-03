package com.sb.algorithms.hexlet.concurrency.module0.e1.task;

import java.util.Arrays;

public class SumRunnable implements Runnable {
    private final int[] ints;
    private int sum;

    public SumRunnable(final int[] ints) {
        this.ints = ints;
    }

    @Override
    public void run() {
        sum = Arrays.stream(ints).sum();
    }

    public int getResult() {
        return sum;
    }
}
