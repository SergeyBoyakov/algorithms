package com.sb.concurrency.educative.ordered_printing;

import java.util.concurrent.CountDownLatch;

public class OrderedPrintingCountDownLatch implements IOrderedPrinting {
    CountDownLatch firstLatch;
    CountDownLatch secondLatch;

    public OrderedPrintingCountDownLatch(final CountDownLatch firstLatch,
                                         final CountDownLatch secondLatch) {
        this.firstLatch = firstLatch;
        this.secondLatch = secondLatch;
    }

    public OrderedPrintingCountDownLatch() {
        this.firstLatch = new CountDownLatch(1);
        this.secondLatch = new CountDownLatch(1);
    }

    public void printFirst() {
        System.out.println("First");
        firstLatch.countDown();
    }

    public void printSecond() throws InterruptedException {
        firstLatch.await();
        System.out.println("Second");
        secondLatch.countDown();
    }

    public void printThird() throws InterruptedException {
        secondLatch.await();
        System.out.println("Third");
    }
}
