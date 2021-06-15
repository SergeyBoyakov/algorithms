package com.sb.concurrency.educative.print_number_series;

public class Demonstration {
    public static void main(String[] args) {
        PrintNumberSeries printNumberSeries = new PrintNumberSeries(5);
        Thread t1 = new PrintNumberSeriesThread(printNumberSeries, "zero");
        Thread t2 = new PrintNumberSeriesThread(printNumberSeries, "even");
        Thread t3 = new PrintNumberSeriesThread(printNumberSeries, "odd");
        t2.start();
        t1.start();
        t3.start();
    }
}
