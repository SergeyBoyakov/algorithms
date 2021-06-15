package com.sb.concurrency.educative.ordered_printing;

public class Demonstration {
    public static void main(String[] args) {
//        OrderedPrinting orderedPrinting = new OrderedPrinting();
        OrderedPrintingCountDownLatch orderedPrinting = new OrderedPrintingCountDownLatch();
        OrderedPrintingThread t1 = new OrderedPrintingThread(orderedPrinting, "first");
        OrderedPrintingThread t2 = new OrderedPrintingThread(orderedPrinting, "second");
        OrderedPrintingThread t3 = new OrderedPrintingThread(orderedPrinting, "third");


        t2.start();
        t3.start();
        t1.start();
    }
}
