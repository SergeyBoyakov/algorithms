package com.sb.algorithms.algoexpert;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        if (array.length == 1 && target == array[0]) {
            return 0;
        }
        if (array.length == 1) {
            return -1;
        }
        int middleIndex = array.length / 2;
        int candidate = array[middleIndex];
        if (candidate == target) {
            return middleIndex;
        }
        if (candidate > target) {
            return binarySearch(Arrays.copyOfRange(array, 0, middleIndex), target);
        } else {
            int result = binarySearch(Arrays.copyOfRange(array, middleIndex, array.length), target);
            if (result == -1) {
                return -1;
            } else return result + middleIndex;
        }
    }
}
