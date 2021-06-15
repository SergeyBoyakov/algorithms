package com.sb.concurrency.educative.print_number_series;

import com.sb.concurrency.educative.async_to_sync_problem.Executor;

public class PrintNumberSeriesThread extends Thread {
    PrintNumberSeries printNumberSeries;
    String method;

    public PrintNumberSeriesThread(final PrintNumberSeries printNumberSeries,
                                   final String method) {
        this.printNumberSeries = printNumberSeries;
        this.method = method;
    }

    public void run() {
        if ("zero".equalsIgnoreCase(method)) {
            try {
                printNumberSeries.printZero();
            } catch (Exception e) {
                // noop
            }
        } else if ("even".equalsIgnoreCase(method)) {
            try {
                printNumberSeries.printEven();
            } catch (Exception e) {
                // noop
            }
        } else if ("odd".equalsIgnoreCase(method)) {
            try {
                printNumberSeries.printOdd();
            } catch (Exception e) {
                // noop
            }
        }
    }
}
