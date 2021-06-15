package com.sb.concurrency.educative.singleton;

public class SupermanSlightlyBetter {
    private static SupermanSlightlyBetter superman;

    private SupermanSlightlyBetter() {
    }

    public static SupermanSlightlyBetter getInstance() {
        if (superman == null) {
            synchronized (SupermanSlightlyBetter.class) {
                if (superman == null) {
                    // *****************************************************************************
                    // it is possible that the var superman is non-null but the object it points to,
                    // is still being initialized in constructor by another thread. Check JMM.
                    // Check solution in in Superman class
                    // *****************************************************************************
                    superman = new SupermanSlightlyBetter();

                }
            }
        }

        return superman;
    }
}
