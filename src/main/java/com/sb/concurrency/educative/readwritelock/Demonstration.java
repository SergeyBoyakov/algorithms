package com.sb.concurrency.educative.readwritelock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class Demonstration {
    public static void main(String[] args) throws Exception {
        final ReadWriteLock lock = new ReadWriteLock();

        Thread firstThread = new Thread(() -> {
            try {
                System.out.println("Attemptoing to acquire write lock in first thread: " + now().get());
                lock.acquireWriteLock();
                System.out.println("write lock acquired by first thread: " + now().get());

                // Simulates write lock being held indefinitely
                for (; ; ) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException ie) {
                // noop
            }
        });

        Thread secondThread = new Thread(() -> {
            try {
                System.out.println("Attempting to acquire write lock in second thread: " + now().get());
                lock.acquireWriteLock();
                System.out.println("write lock acquired in second thread: " + now().get());
            } catch (InterruptedException e) {
                // noop
            }
        });

        Thread firstReadThread = new Thread(() -> {
            try {
                lock.acquireReadLock();
                System.out.println("Read lock acquired: " + now().get());
            } catch (InterruptedException e) {
                // noop
            }
        });

        Thread secondReadThread = new Thread(() -> {
            System.out.println("Read lock about to release: " + now().get());
            lock.releaseReadLock();
            System.out.println("Read lock released: " + now().get());
        });

        firstReadThread.start();
        firstThread.start();
        Thread.sleep(3_000);

        secondReadThread.start();
        Thread.sleep(1_000);
        secondThread.start();
        firstReadThread.join();
        secondReadThread.join();
        secondThread.join();
    }

    private static Supplier<String> now() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();

        return () -> format.format(date);
    }
}
