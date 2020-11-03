package com.sb.algorithms.hexlet.concurrency.module2.e0;

import java.util.concurrent.Callable;

public class SumCallable implements Callable<Integer> {
    private final int left;
    private final int right;

    public SumCallable(final int right, final int left) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer call() throws Exception {
        return left + right;
    }
}
