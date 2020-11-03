package com.sb.algorithms.hexlet.concurrency.module1.e0.task;


public class ThreadHelper {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 47; i += 4) {
            final long before = System.currentTimeMillis();
            int result = fib(i);
            final long after = System.currentTimeMillis();
            System.out.println("Input: " + i + "\t\tResult: " + result + "\t\t\t\t\t\t\tTimeMillis: " + (after - before));
        }
    }

    public static int fib(final int numberToCalculate) throws Exception {
        final FibCalculator fibCalculator = new FibCalculator(numberToCalculate);
        fibCalculator.start();
        fibCalculator.join();
//        fibCalculator.fibSyncWrapper(numberToCalculate);

        return fibCalculator.getResult();
    }

    private static class FibCalculator extends Thread {
        private int numberToCalculate;
        private int result;
        private int leftResult;
        private int rightResult;

        public FibCalculator(final int numberToCalculate) {
            this.numberToCalculate = numberToCalculate;
        }

        public void fibSyncWrapper(final int input) {
            result = fibSync(input);
        }

        private int fibSync(final int input) {
            if (input == 1 || input == 2) return 1;
            return fibSync(input - 1) + fibSync(input - 2);
        }

        @Override
        public void run() {
            try {
                calculate(numberToCalculate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void calculate(final int input) throws InterruptedException {
            assert input > 0;
            if (input == 1 || input == 2) {
                result = 1;
                return;
            }

            final Thread left = new Thread(() -> calculateLeftWrapper(input - 1));
            final Thread right = new Thread(() -> calculateRightWrapper(input - 2));
            left.start();
            right.start();
            left.join();
            right.join();

            result = leftResult + rightResult;
        }

        private void calculateLeftWrapper(final int input) {
            leftResult = calculateLeft(input);
        }

        private int calculateLeft(final int input) {
            if (input < 1) return 0;
            if (input == 1 || input == 2) return 1;
            return calculateLeft(input - 1) + calculateLeft(input - 2);
        }

        private void calculateRightWrapper(final int input) {
            rightResult = calculateRight(input);
        }

        private int calculateRight(final int input) {
            if (input < 1) return 0;
            if (input == 1 || input == 2) return 1;
            return calculateRight(input - 1) + calculateRight(input - 2);
        }

        public int getResult() {
            return result;
        }
    }
}
