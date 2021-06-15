package com.sb.concurrency.educative.thread_safe_deferred_callback;

import java.util.PriorityQueue;
import java.util.Random;

public class Demonstration {

    public static void main(String[] args) throws InterruptedException {
        runLateThenEarlyCallback();
    }

    private static void runLateThenEarlyCallback() throws InterruptedException {
        final DeferredCallback deferredCallback = new DeferredCallback();

        Thread service = new Thread(() -> {
            try {
                deferredCallback.start();
            } catch (InterruptedException interruptedException) {
                // noop
            }
        });

        service.start();

        Thread lateThread = new Thread(() -> {
            DeferredCallback.Callback cb = new DeferredCallback.Callback(8, "Hello this is the callback submitted first");
            deferredCallback.registerCallback(cb);
        });
        lateThread.start();

        Thread.sleep(3_000);

        Thread earlyThread = new Thread(() -> {
            DeferredCallback.Callback cb = new DeferredCallback.Callback(1, "Hello this is callback submitted second");
            deferredCallback.registerCallback(cb);
        });
        earlyThread.start();

        lateThread.start();
        earlyThread.join();

    }
}


