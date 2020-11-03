package com.sb.concurrency.hexlet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibCalculator extends Thread {
    private final int currentNum;

    private int result;

    public FibCalculator(final int numberToCalculate) {
        this.currentNum = numberToCalculate;
    }

    @Override
    public void run() {
        if (currentNum == 1 || currentNum == 2) {
            result = 1;
            return;
        }
        final FibCalculator left = new FibCalculator(currentNum - 1);
        final FibCalculator right = new FibCalculator(currentNum - 2);
        left.start();
        right.start();
        try {
            left.join();
            right.join();
        } catch (final InterruptedException e) {
        }
        result = left.getResult() + right.getResult();
    }

    public int getResult() {
        return result;
    }
}

class FibCalculatorExecutorService {
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    public static int fib(final int numberToCalculate) throws Exception {
        Future<?> futureResult = EXECUTOR_SERVICE.submit(() -> iter(numberToCalculate));

        return (Integer) futureResult.get();
    }

    private static int iter(int numberToCalculate) {
        if (numberToCalculate == 1 || numberToCalculate == 2) {
            return 1;
        }

        return iter(numberToCalculate - 1) + iter(numberToCalculate - 2);
    }
}
