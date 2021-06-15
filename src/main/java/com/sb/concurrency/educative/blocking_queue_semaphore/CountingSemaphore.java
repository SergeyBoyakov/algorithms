package com.sb.concurrency.educative.blocking_queue_semaphore;

public class CountingSemaphore {
    int usedPermits =0;
    int maxCount;

    public CountingSemaphore(final int maxCount) {
        this.maxCount = maxCount;
    }

    public CountingSemaphore(final int count,final int initialPermits) {
        this.usedPermits = this.maxCount-initialPermits;
        this.maxCount = count;
    }

    public synchronized void acquire() throws InterruptedException {
        while (usedPermits == maxCount) {
            wait();
        }

        notify();
        usedPermits++;
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits == 0) {
            wait();
        }

        usedPermits--;
        notify();
    }
}
