package com.sb.concurrency.educative.merge_sort;

public class MultiThreadedMergeSort {
    private static int SIZE = 25;
    private int[] input = new int[SIZE];
    private int[] scratch = new int[SIZE];

    void mergeSort(final int startIndex, final int endIndex, final int[] input) {
        if (startIndex == endIndex) {
            return;
        }

        final int midIndex = startIndex + ((endIndex - startIndex) / 2);

        // sort first half
        Thread worker1 = new Thread(() -> {
            mergeSort(startIndex, midIndex, input);
        });

        // sort second half
        Thread worker2 = new Thread(() -> {
            mergeSort(midIndex + 1, endIndex, input);
        });

        // start the threads
        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException interruptedException) {
            // noop
        }

        // merge the two sorted arrays
        int i = startIndex;
        int j = midIndex + 1;
        int k;

        for (k = startIndex; k <= endIndex; k++) {
            scratch[k] = input[k];
        }

        k = startIndex;
        while (k <= endIndex) {
            if (i <= midIndex && j <= endIndex) {
                input[k] = Math.min(scratch[i], scratch[j]);

                if (input[k] == scratch[i]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i <= midIndex && j > endIndex) {
                input[k] = scratch[i];
                i++;
            } else {
                input[k] = scratch[j];
                j++;
            }
            k++;
        }
    }
}
