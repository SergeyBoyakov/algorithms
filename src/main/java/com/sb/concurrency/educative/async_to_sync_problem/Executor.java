package com.sb.concurrency.educative.async_to_sync_problem;

public class Executor {
    public void asynchronousExecution(final Callback callback) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                // simulate usefull work by sleeping
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                // noop
            }
            callback.done();
        });
        thread.start();
    }
}
