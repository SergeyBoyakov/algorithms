package com.sb.concurrency.educative.merge_sort;

import java.util.Random;

public class Demonstration {
    private static int SIZE = 25;
    private static Random random = new Random(System.currentTimeMillis());
    private static int[] input = new int[SIZE];

    private static void createTestData() {
        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(10_000);
        }
    }

    private static void printArray(final int[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.println(" " + input[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        createTestData();

        System.out.println("Unsorted array");
        printArray(input);
        long start = System.currentTimeMillis();
        (new MultiThreadedMergeSort()).mergeSort(0, input.length - 1, input);
//        SingleThreadedMergeSort.mergeSort(0, input.length - 1, input);
        long end = System.currentTimeMillis();
        System.out.println("\n\nTime taken to sort = " + (end - start) + " milliseconds");
        System.out.println("Sorted array");
        printArray(input);
    }
}
