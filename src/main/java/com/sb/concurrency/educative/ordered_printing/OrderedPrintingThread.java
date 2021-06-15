package com.sb.concurrency.educative.ordered_printing;

public class OrderedPrintingThread extends Thread {
    private IOrderedPrinting orderedPrinting;
    private String method;

    public OrderedPrintingThread(final IOrderedPrinting orderedPrinting,
                                 final String method) {
        this.method = method;
        this.orderedPrinting = orderedPrinting;
    }

    public void run() {
        // for printing first
        if ("first".equals(method)) {
            orderedPrinting.printFirst();
        }
        // for printing second
        else if ("second".equals(method)) {
            try {
                orderedPrinting.printSecond();
            } catch (InterruptedException exception) {
                // noop
            }
        }
        // for printing "third"
        else if ("third".equals(method)) {
            try {
                orderedPrinting.printThird();
            } catch (InterruptedException interruptedException) {
                // noop
            }
        }
    }
}
