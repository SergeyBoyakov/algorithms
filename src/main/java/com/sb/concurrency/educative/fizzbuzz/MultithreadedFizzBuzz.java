package com.sb.concurrency.educative.fizzbuzz;

public class MultithreadedFizzBuzz {

    private int n; // last number of the series to be printed
    private int num = 1; // represents the current number to be printed

    public MultithreadedFizzBuzz(final int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 != 0) {
                System.out.println("fizz");
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (num <= n) {
            if (num % 5 == 0 && num % 3 != 0) {
                System.out.println("buzz");
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (num <= n) {
            if (num % 15 == 0) {
                System.out.println("fizzbuzz");
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 != 0) {
                System.out.println(num);
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}

