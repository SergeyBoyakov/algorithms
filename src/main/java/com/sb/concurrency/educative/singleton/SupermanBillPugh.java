package com.sb.concurrency.educative.singleton;

public class SupermanBillPugh {
    private SupermanBillPugh() {

    }

    private static class Holder{
        private static final SupermanBillPugh superman = new SupermanBillPugh();
    }

    public static SupermanBillPugh getInstance() {
        return Holder.superman;
    }
}
