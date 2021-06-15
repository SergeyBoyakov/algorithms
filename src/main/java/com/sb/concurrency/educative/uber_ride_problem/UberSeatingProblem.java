package com.sb.concurrency.educative.uber_ride_problem;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This lesson solves the constraints of an imaginary Uber ride problem where Republicans and Democrats
 * can't be seated as a minority in a four passenger car.
 */
public class UberSeatingProblem {
    private int republicans = 0;
    private int democrats = 0;

    CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    ReentrantLock lock = new ReentrantLock();

    private Semaphore democratsWaiting = new Semaphore(0);
    private Semaphore republicansWaiting = new Semaphore(0);

    void seatDemocrat() throws InterruptedException, BrokenBarrierException {
        boolean rideLeader = false; // thread, that signals other threads to come along for the ride
        lock.lock();

        democrats++;

        if (democrats == 4) {
            // seat all the democrats in the uber ride
            democratsWaiting.release(3);
            democrats -= 4;
            rideLeader = true;
        } else if (democrats == 2 && republicans >= 2) {
            // seat 2 democrats & 2 republicans
            democratsWaiting.release(1);
            republicansWaiting.release(2);
            rideLeader = true;
            democrats -= 2;
            republicans -= 2;
        } else {
            lock.unlock();
            democratsWaiting.acquire();
        }

        seated();
        cyclicBarrier.await();

        if (rideLeader) {
            drive();
            lock.unlock();
        }
    }

    void seatRepublicans() throws InterruptedException, BrokenBarrierException {
        boolean rideLeader = false;
        lock.lock();

        republicans++;

        if (republicans == 4) {
            // seat all the republicans in the Uber ride
            republicansWaiting.release(3);
            rideLeader = true;
            republicans -= 4;
        } else if (republicans == 2 && democrats >= 2) {
            // seat 2 democrats & 2 republicans
            republicansWaiting.release(1);
            democratsWaiting.release(2);
            rideLeader = true;
            republicans -= 2;
            democrats -= 2;
        } else {
            lock.unlock();
            republicansWaiting.acquire();
        }

        seated();
        cyclicBarrier.await();

        if (rideLeader) {
            drive();
            lock.unlock();
        }

    }

    void seated() {
        System.out.println(Thread.currentThread().getName() + " seated");
        System.out.flush();
    }

    void drive() {
        System.out.println("Uber Ride on its way . . . with ride leader " + Thread.currentThread().getName());
        System.out.flush();
    }

}
