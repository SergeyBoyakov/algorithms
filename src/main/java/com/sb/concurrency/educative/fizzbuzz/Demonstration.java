package com.sb.concurrency.educative.fizzbuzz;

public class Demonstration {
    public static void main(String[] args) {
        MultithreadedFizzBuzz multithreadedFizzBuzz = new MultithreadedFizzBuzz(15);
        Thread t1 = new FizzBuzzThread(multithreadedFizzBuzz, "fizz");
        Thread t2 = new FizzBuzzThread(multithreadedFizzBuzz, "buzz");
        Thread t3 = new FizzBuzzThread(multithreadedFizzBuzz, "fizzbuzz");
        Thread t4 = new FizzBuzzThread(multithreadedFizzBuzz, "number");

        t2.start();
        t1.start();
        t4.start();
        t3.start();
    }
}
