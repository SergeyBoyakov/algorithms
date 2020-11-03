package com.sb.algorithms.hexlet.concurrency.module2.e0;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executor = Executors.newWorkStealingPool();
        final SumRunnable sumRunnable = new SumRunnable(1, 2);
        final Future<?> future = executor.submit(sumRunnable);
        future.get();
        System.out.println(sumRunnable.getResult());
    }
}
