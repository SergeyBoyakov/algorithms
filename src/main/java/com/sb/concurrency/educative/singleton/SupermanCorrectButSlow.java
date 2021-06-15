package com.sb.concurrency.educative.singleton;

public class SupermanCorrectButSlow {
    private static SupermanCorrectButSlow supermanCorrectButSlow;

    private SupermanCorrectButSlow() {
    }

    public static SupermanCorrectButSlow getInstance() {
        synchronized (SupermanCorrectButSlow.class) {
            if (supermanCorrectButSlow == null) {
                supermanCorrectButSlow = new SupermanCorrectButSlow();
            }
        }
        return supermanCorrectButSlow;
    }

    public void fly() {
        System.out.println("I am Superman ! ! !");
    }
}
