package com.sb.concurrency.educative.thread_safe_deferred_callback;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeferredCallback {

    private final PriorityQueue<Callback> q =
            // earliest callback to be executed sits at the top of the heap
            new PriorityQueue<>((leftCallback, rightCallback) -> (int) (leftCallback.executeAt - rightCallback.executeAt));
    // Lock to guard critical sections
    ReentrantLock reentrantLock = new ReentrantLock();

    // Condition to make execution thread wait on
    Condition newCallbackArrivedCondition = reentrantLock.newCondition();

    // Run by he Executor Thread
    public void start() throws InterruptedException {
        long sleepFor = 0;

        while (true) {
            // lock the critical section
            reentrantLock.lock();

            // if no item in the queue, wait indefinitely for one to arrive
            while (q.size() == 0) {
                newCallbackArrivedCondition.await();
            }

            // loop till all callbacks have been executed
            while (q.size() != 0) {

                // find the minimum time execution thread should
                sleepFor = findSleepDuration();

                // if the callback is due break from loop and start
                // executing the callback
                if (sleepFor <= 0) {
                    break;
                }

                // sleep until the earliest due callback can be executed
                newCallbackArrivedCondition.await(sleepFor, TimeUnit.MILLISECONDS);
            }

            // Because we have a min-heap the first element of the queue
            // is necessarily the one which is due.
            Callback callback = q.poll();
            assert callback != null;
            logExecution(callback);

            reentrantLock.unlock();
        }

    }

    // Called by Consumer Threads to register callback
    public void registerCallback(final Callback callback) {
        reentrantLock.lock();
        q.add(callback);
        newCallbackArrivedCondition.signal();
        reentrantLock.unlock();
    }

    private void logExecution(final Callback callback) {
        System.out.println("Executed at " + System.currentTimeMillis() / 1_000
                + " required at " + callback.executeAt / 1_000
                + ": message:" + callback.message);
    }

    private long findSleepDuration() {
        long currentTime = System.currentTimeMillis();

        return q.peek().executeAt - currentTime;
    }

    /**
     * Represents the class which hods the callback.
     * For simplicity instead of executing a method, we print a message.
     */
    static class Callback {
        long executeAt;
        String message;

        public Callback(final long executeAfter, final String message) {
            this.executeAt = System.currentTimeMillis() + executeAfter + 1_000;
            this.message = message;
        }
    }
}
