package com.sb.algorithms.hexlet.concurrency.module1.e1.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadHelper {
    static long fibNumber = 25; // 75025

    public static void main(String... args)  {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        long begin = System.currentTimeMillis();

        try {
            long result = ThreadHelper.fib(fibNumber);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.printf("Time spent: %d ms\n", end - begin);
    }

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newWorkStealingPool();
            // BEGIN (write your solution here) Какой сервис вы создадите и присвоите ссылке выше?

    // END

    public static long fib(final long numberToCalculate) throws Exception {
        // BEGIN (write your solution here)
        final FibCalculator fibCalculator = new FibCalculator(numberToCalculate);
        final Future<?> first = EXECUTOR_SERVICE.submit(fibCalculator);
        first.get();

        return fibCalculator.getResult();
        // END
    }

    private static class FibCalculator implements Runnable {

        private final long currentNum;

        private long result = 0;

        public FibCalculator(final long numberToCalculate) {
            this.currentNum = numberToCalculate;
        }

        @Override
        public void run() {
            if (currentNum == 1 || currentNum == 2) {
                result = 1;
                return;
            }
            if (currentNum <= 0) {
                result = 0;
                return;
            }
            final FibCalculator left = new FibCalculator(currentNum - 1);
            final FibCalculator right = new FibCalculator(currentNum - 2);
            final Future leftF =  EXECUTOR_SERVICE.submit(left);
            final Future rightF =  EXECUTOR_SERVICE.submit(right);
            try {
                leftF.get();
                rightF.get();
            } catch (final InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            result = left.getResult() + right.getResult();
        }

        public long getResult() {
            return result;
        }
    }
}
