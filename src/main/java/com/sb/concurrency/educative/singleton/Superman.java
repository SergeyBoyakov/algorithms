package com.sb.concurrency.educative.singleton;

public class Superman {
    private static volatile Superman superman;

    private Superman() {

    }

    public static Superman getInstance() {
        if (superman == null) {
            synchronized (Superman.class) {
                // link can be != null even if class not fully instantiated -> solution is volatile (happens before)
                if (superman == null) {
                    superman = new Superman();
                }
            }
        }

        return superman;
    }

    public void fly() {
        System.out.println("I am Superman & I can fly !");
    }
}
