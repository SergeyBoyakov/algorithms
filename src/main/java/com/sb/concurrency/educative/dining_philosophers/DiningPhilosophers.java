package com.sb.concurrency.educative.dining_philosophers;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 5 Philosophers
 * 1 table
 * 5 forks
 * Each phil is contemplating or eating
 * To eat philosopher should have 2 forks
 * One fork should be from the left and one from the right of him
 * Each thread is a philosopher
 * <p>
 * Need solution without deadlock
 */
public class DiningPhilosophers {
    private static final Random random = new Random(System.currentTimeMillis()); // variable for test proposes

    private final Semaphore[] forks = new Semaphore[5]; // represent five forks
    private final Semaphore maxDiners = new Semaphore(4);

    public DiningPhilosophers() {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    public void lifecycleOfPhilosopher(final int i) throws InterruptedException {
        while (true) {
            contemplate();
            eat(i);
        }
    }

    // We can sleep the thread when the philosopher is thinking
    void contemplate() throws InterruptedException {
        Thread.sleep(random.nextInt(500));
    }

    // MEAT of solution, philosophers try to start eat here
    void eat(final int threadId) throws InterruptedException {
        // depricated
        // maxDiners allows only 4 philosophers to attempt picking up forks
        //        maxDiners.acquire();

        // We randomly selected the philosopher with id 3 as left-handed. All other must be right-handed to avoid a deadlock
        if (threadId == 3) {
            acquireForkForLeftHanded(3);
        } else {
            acquireForkForRightHanded(threadId);
        }

        System.out.println("Philosopher " + threadId + " is eating");

        // release forks for other to use
        forks[getLeftForkId(threadId)].release();
        forks[getRightForkId(threadId)].release();

        // depricated
        //        maxDiners.release();
    }

    void acquireForkForRightHanded(final int threadId) throws InterruptedException {
        forks[threadId].acquire();
        forks[(threadId + 1) % 5].acquire();
    }

    void acquireForkForLeftHanded(final int threadId) throws InterruptedException {
        forks[(threadId + 1) % 5].acquire();
        forks[threadId].acquire();
    }

    private int getLeftForkId(final int threadId) {
        return threadId;
    }

    private int getRightForkId(final int threadId) {
        return (threadId + 4) % 5;
    }
}
