package com.sb.algorithms.hexlet.concurrency.module0;

public class Main {
    public static void main(String[] args) {
        final MockLoader textFromFileLoader = new MockLoader("textFromFile");
        final MockLoader textFromWebLoader = new MockLoader("textFromWeb");

        final long before = System.currentTimeMillis();

        System.out.println(textFromFileLoader.loadText());
        System.out.println(textFromWebLoader.loadText());

        final long after = System.currentTimeMillis();
        System.out.printf("time delta: %d /n", (after - before) / 1_000);
    }
}
