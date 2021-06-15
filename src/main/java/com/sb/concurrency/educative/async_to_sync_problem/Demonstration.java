package com.sb.concurrency.educative.async_to_sync_problem;

public class Demonstration {
    public static void main(String[] args) throws Exception {
//        Executor executor = new Executor();
        SynchronousExecutor executor = new SynchronousExecutor();
        executor.asynchronousExecution(() -> {
            System.out.println("I am done");
        });

        System.out.println("main thread exiting . . .");
    }
}
