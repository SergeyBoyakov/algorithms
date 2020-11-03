package com.sb.algorithms.hexlet.concurrency.module0.e1.task;

import java.util.Arrays;

public class SumThread extends Thread {
    private int[] integers;
    private int sum;

    public SumThread(final int[] integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        sum = Arrays.stream(this.integers).sum();
    }

    public int getResult() {
        return sum;
    }
}

