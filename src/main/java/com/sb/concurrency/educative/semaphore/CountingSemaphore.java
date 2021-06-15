package com.sb.concurrency.educative.semaphore;

public class CountingSemaphore {
    int givenOutPermits = 0;
    int maxPermitsToGiveOut;

    public CountingSemaphore(final int maxPermitsToGiveOut) {
        this.maxPermitsToGiveOut = maxPermitsToGiveOut;
    }

    public synchronized void acquire() throws InterruptedException {
        while (givenOutPermits == maxPermitsToGiveOut) {
            wait();
        }

        givenOutPermits++;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (givenOutPermits == 0) {
            wait();
        }

        givenOutPermits--;
        notify();
    }


}
