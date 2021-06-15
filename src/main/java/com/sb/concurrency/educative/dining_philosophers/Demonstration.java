package com.sb.concurrency.educative.dining_philosophers;

import java.util.function.Supplier;

public class Demonstration {

    public static void main(String[] args) throws InterruptedException {
        final DiningPhilosophers diningPhilosophers = new DiningPhilosophers();

        Thread first = new Thread(() -> startPhilosopher(diningPhilosophers, 0));
        Thread second = new Thread(() -> startPhilosopher(diningPhilosophers, 1));
        Thread third = new Thread(() -> startPhilosopher(diningPhilosophers, 2));
        Thread fourth = new Thread(() -> startPhilosopher(diningPhilosophers, 3));
        Thread fifth = new Thread(() -> startPhilosopher(diningPhilosophers, 4));

        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();

        first.join();
        second.join();
        third.join();
        fourth.join();
        fifth.join();
    }

    private static void startPhilosopher(DiningPhilosophers philosophers, int id) {
        try {
            philosophers.lifecycleOfPhilosopher(id);
        } catch (InterruptedException ie) {
            // noop
        }
    }

}
