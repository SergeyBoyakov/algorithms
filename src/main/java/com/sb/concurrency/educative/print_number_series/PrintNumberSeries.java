package com.sb.concurrency.educative.print_number_series;

import java.util.concurrent.Semaphore;

/**
 * printing 010203
 * 0 by thread 1
 * 1 3 5 7 . . . by thread 2
 * 2 4 6 8 . . . by thread 3
 */
public class PrintNumberSeries {
    private final int n;
    private final Semaphore zeroSemaphore;
    private final Semaphore oddSemaphore;
    private final Semaphore evenSemaphore;

    public PrintNumberSeries(final int n) {
        this.n = n;
        zeroSemaphore = new Semaphore(1);
        oddSemaphore = new Semaphore(0);
        evenSemaphore = new Semaphore(0);
    }

    public void printZero() {
        for (int i = 0; i < n; i++) {
            try {
                zeroSemaphore.acquire();
            } catch (InterruptedException interruptedException) {
                // noop
            }
            System.out.println("0");
            (i % 2 == 0 ? oddSemaphore : evenSemaphore).release();
        }
    }

    public void printOdd() {
        for (int i = 1; i <= n; i += 2) {
            try {
                oddSemaphore.acquire();
            } catch (InterruptedException interruptedException) {
                // noop
            }
            System.out.println(i);
            zeroSemaphore.release();
        }

    }

    public void printEven() {
        for (int i = 2; i <= n; i += 2) {
            try {
                evenSemaphore.acquire();
            } catch (InterruptedException interruptedException) {
                // noop
            }
            System.out.println(i);
            zeroSemaphore.release();
        }

    }
}
