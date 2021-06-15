package com.sb.concurrency.educative.barrier;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {

        final Barrier barrier = new Barrier(3);

        Thread first = new Thread(
                () -> {
                    try {
                        System.out.println("First thread");
                        barrier.await();
                        System.out.println("First thread");
                        barrier.await();
                        System.out.println("First thread");
                        barrier.await();
                    } catch (InterruptedException ie) {
                        // noop
                    }
                }
        );

        Thread second = new Thread(
                () -> {
                    try {
                        Thread.sleep(500);
                        System.out.println("Second thread");
                        barrier.await();
                        Thread.sleep(500);
                        System.out.println("Second thread");
                        barrier.await();
                        Thread.sleep(500);
                        System.out.println("Second thread");
                        barrier.await();
                    } catch (InterruptedException ie) {
                        // noop
                    }
                }
        );

        Thread third = new Thread(
                () -> {
                    try {
                        Thread.sleep(1500);
                        System.out.println("Third thread");
                        barrier.await();
                        Thread.sleep(1500);
                        System.out.println("Third thread");
                        barrier.await();
                        Thread.sleep(1500);
                        System.out.println("Third thread");
                        barrier.await();
                    } catch (InterruptedException ie) {
                        // noop
                    }
                }
        );

        first.start();
        second.start();
        third.start();

        first.join();
        second.join();
        third.join();
    }
}
