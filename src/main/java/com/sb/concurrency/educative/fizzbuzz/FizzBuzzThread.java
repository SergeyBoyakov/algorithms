package com.sb.concurrency.educative.fizzbuzz;

public class FizzBuzzThread extends Thread {
    MultithreadedFizzBuzz multithreadedFizzBuzz;
    String method;

    public FizzBuzzThread(MultithreadedFizzBuzz multithreadedFizzBuzz, String method) {
        this.multithreadedFizzBuzz = multithreadedFizzBuzz;
        this.method = method;
    }

    public void run() {
        if ("fizz".equalsIgnoreCase(method)) {
            try {
                multithreadedFizzBuzz.fizz();

            } catch (InterruptedException ie) {
            }
        } else if ("buzz".equalsIgnoreCase(method)) {
            try {
                multithreadedFizzBuzz.buzz();

            } catch (InterruptedException ie) {
            }
        } else if ("fizzbuzz".equalsIgnoreCase(method)) {
            try {
                multithreadedFizzBuzz.fizzbuzz();

            } catch (InterruptedException ie) {
            }
        } else if ("number".equalsIgnoreCase(method)) {
            try {
                multithreadedFizzBuzz.number();

            } catch (InterruptedException ie) {
            }
        }

    }
}
