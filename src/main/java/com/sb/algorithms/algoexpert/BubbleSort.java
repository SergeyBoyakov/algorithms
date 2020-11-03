package com.sb.algorithms.algoexpert;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        if (array.length == 1) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(i, j, array);
                }
            }
        }

        return array;
    }

    private static void swap(int leftIndex, int rightIndex, int[] arr) {
        int tmp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = tmp;
    }

    public static void main(String... args){

    }
}
