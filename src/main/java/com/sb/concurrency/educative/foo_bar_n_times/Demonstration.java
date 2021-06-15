package com.sb.concurrency.educative.foo_bar_n_times;

public class Demonstration {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        Thread t1 = new FooBarThread(fooBar, "foo");
        Thread t2 = new FooBarThread(fooBar, "bar");

        t2.start();
        t1.start();

    }
}
