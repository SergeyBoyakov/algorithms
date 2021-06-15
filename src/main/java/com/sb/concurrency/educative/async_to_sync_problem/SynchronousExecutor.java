package com.sb.concurrency.educative.async_to_sync_problem;

import net.jcip.annotations.ThreadSafe;

public class SynchronousExecutor extends Executor{

    // thread-safe
    @Override
    public void asynchronousExecution(final Callback callback) throws Exception {
        Object signal = new Object();
        final boolean[] isDone = new boolean[1];

        Callback localCallback = () -> {
            callback.done();
            synchronized (signal) {
                signal.notify();
                isDone[0] = true;
            }
        };
        super.asynchronousExecution(localCallback);

        synchronized (signal) {
            while (!isDone[0]) { // infinite loop to avoid spurious wakeups
                signal.wait();
            }
        }
    }
}
