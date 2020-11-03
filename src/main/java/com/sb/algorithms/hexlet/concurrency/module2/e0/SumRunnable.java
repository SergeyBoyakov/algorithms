package com.sb.algorithms.hexlet.concurrency.module2.e0;

public class SumRunnable implements Runnable {
    private final int left;
    private final int right;
    private int result;

    public SumRunnable(final int left, final int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        result = left + right;
    }

    public int getResult() {
        return result;
    }
}
