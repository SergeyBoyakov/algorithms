package com.sb.concurrency.educative.barrier;

public class Barrier {
    int count = 0;
    int released = 0;
    int maximumThreads;

    public Barrier(int totalThreads) {
        this.maximumThreads = totalThreads;
    }

    public synchronized void await() throws InterruptedException {
        // block any new threads from proceeding till all threads from previous barrier are released
        while(count==maximumThreads) wait();

        // increment the counter whenever a thread arrives at the barrier
        count++;

        if (count == maximumThreads) {
            // wake up all the threads
            notifyAll();
            // remember to set released to maximumThreads
            released = maximumThreads;
        } else {
            // wait till all threads reach barrier
            while (count < maximumThreads) {
                wait();
            }
        }

        released--;
        if (released == 0) {
            count=0;
            // remember to wakeup any threads waiting on line#14
            notifyAll();
        }
    }
}
