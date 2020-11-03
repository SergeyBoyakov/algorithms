package com.sb.algorithms.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        // List<Integer> numbers = new ArrayList(asList(array));
        List<Integer[]> result = new ArrayList<>();
        if (array.length < 3) {
            return result;
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int sum = sumOf(array[i], array[j], array[k]);
                    if (sum == targetSum) {
                        result.add(new Integer[]{array[i], array[j], array[k]});
                    }
                }
            }
        }

        return result;
    }

    private static int sumOf(int... numbers) {
        return stream(numbers).sum();
    }

//    private static class Triplet {
//        private final int first;
//        private final int second;
//        private final int third;
//
//        public Triplet(int first, int second, int third) {
//            this.first = first;
//            this.second = second;
//            this.third = third;
//        }
//
//        public int getSum() {
//            return first + second + third;
//        }
//    }
}
