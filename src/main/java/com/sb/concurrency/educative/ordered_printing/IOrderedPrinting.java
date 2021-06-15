package com.sb.concurrency.educative.ordered_printing;

public interface IOrderedPrinting {
    void printFirst();

    void printSecond() throws InterruptedException;

    void printThird() throws InterruptedException;
}
