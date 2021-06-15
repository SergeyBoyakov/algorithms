package com.sb.concurrency.educative.singleton;

public class SupermanNaiveButCorrect {
    private static SupermanNaiveButCorrect instance = new SupermanNaiveButCorrect();

    private SupermanNaiveButCorrect() {
    }

    public static SupermanNaiveButCorrect getInstance() {
        return instance;
    }

    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}
