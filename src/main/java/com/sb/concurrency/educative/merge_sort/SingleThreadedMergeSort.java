package com.sb.concurrency.educative.merge_sort;

public class SingleThreadedMergeSort {
    private static int[] scratch = new int[25];

    public static void main(String[] args) {
        int[] input = new int[]{7, 5, 4, 6,1,1,11,1,1,1,1,1,1,1,1,};
        printArray(input, "Before: ");
        mergeSort(0, input.length - 1, input);
        printArray(input, "After: ");
    }

    public static void mergeSort(final int startIndex, final int endIndex, final int[] input) {
        if (startIndex == endIndex) {
            return;
        }

        int midIndex = startIndex + ((endIndex - startIndex) / 2);

        // sort first half
        mergeSort(startIndex, midIndex, input);

        // sort second half
        mergeSort(midIndex + 1, endIndex, input);

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

    private static void printArray(final int[] input, final String msg) {
        System.out.println();
        System.out.print(msg + " ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(" " + input[i] + " ");
        }
        System.out.println();
    }

}
