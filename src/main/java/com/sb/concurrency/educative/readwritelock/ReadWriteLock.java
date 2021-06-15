package com.sb.concurrency.educative.readwritelock;

/**
 * Only 1 write thread
 * Any amount of read threads
 * If there is 1 or more read thread -> lock for write
 * If there is 1 write thread -> lock for read
 */
public class ReadWriteLock {
    boolean isWriteLocked = false;
    int readers = 0;

    public synchronized void acquireReadLock() throws InterruptedException {
        while (isWriteLocked) {
            wait();
        }

        readers++;
    }

    public synchronized void releaseReadLock() {
        readers--;
        notify();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (isWriteLocked || readers != 0) {
            wait();
        }

        isWriteLocked = true;
    }

    public synchronized void releaseWriteLock() {
        isWriteLocked = false;
        notify();
    }
}
