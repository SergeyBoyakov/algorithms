package com.sb.concurrency.educative.foo_bar_n_times;

public class FooBarThread extends Thread{
    private final FooBar fooBar;
    private final String method;

    public FooBarThread(final FooBar fooBar, final String method) {
        this.fooBar = fooBar;
        this.method = method;
    }

    public void run() {
        if ("foo".equalsIgnoreCase(method)) {
            fooBar.foo();
        } else if ("bar".equalsIgnoreCase(method)) {
            fooBar.bar();
        }

    }
}
