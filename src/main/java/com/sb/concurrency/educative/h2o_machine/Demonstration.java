package com.sb.concurrency.educative.h2o_machine;

public class Demonstration {
    public static void main(String[] args) {
        H2OMachine h2OMachine = new H2OMachine();

        Thread t1 = new H2OMachineThread(h2OMachine, "H");
        Thread t2 = new H2OMachineThread(h2OMachine, "O");
        Thread t3 = new H2OMachineThread(h2OMachine, "H");
        Thread t4 = new H2OMachineThread(h2OMachine, "O");

        t2.start();
        t1.start();
        t4.start();
        t3.start();
    }
}
