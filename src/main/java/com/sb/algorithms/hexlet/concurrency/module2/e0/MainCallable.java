package com.sb.algorithms.hexlet.concurrency.module2.e0;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executor = Executors.newWorkStealingPool();
        final SumCallable sumCallable = new SumCallable(1, 2);
        final Future<Integer> submit = executor.submit(sumCallable);
        System.out.println(submit.get());

    }
}
