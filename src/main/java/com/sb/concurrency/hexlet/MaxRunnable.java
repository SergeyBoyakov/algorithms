package com.sb.concurrency.hexlet;

public class MaxRunnable implements Runnable {
    private final int[] target;
    private int result;

    public MaxRunnable(final int[] target) {
        this.target = target;
    }

    @Override
    public void run() {
        result = Integer.MIN_VALUE;
        for (int element : target) {
            if (element > result) result = element;
        }
    }

    public int getResult() {
        return result;
    }
}

