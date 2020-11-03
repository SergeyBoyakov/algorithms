package com.sb.algorithms.algoexpert;

import java.util.*;

public class TwoNumberSum {
    /*
    Two number sum

    [3 5 -4 8 11 1 -1 6], 10 -> [-1,11]
     */
    // my solution
    public int[] myTwoNumberSum(int[] array, int targetSum) {
        if (array.length == 1) {
            return array;
        }

        int[] result = new int[2];

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == targetSum) {
                    result[0] = array[i];
                    result[1] = array[j];
                    return result;
                }
            }
        }

        return new int[0];
    }

    // solution 1
    public int[] twoNumberSumV1(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];
                if (firstNum + secondNum == targetSum) {
                    return new int[]{firstNum, secondNum};
                }
            }
        }

        return new int[0];
    }

    // solution 2
    public int[] twoNumberSumV2(int[] array, int targetSum) {
        // commented their strange solution.
//        Map<Integer, Boolean> nums = new HashMap<>();
        Set<Integer> nums = new HashSet<>();

        for (int num : array) {
            int potentialMatch = targetSum - num;
//            if (nums.containsKey(potentialMatch)) {
            if (nums.contains(potentialMatch)) {
                return new int[]{potentialMatch, num};
            } else {
//                nums.put(num, true);
                nums.add(num);
            }

        }
        return new int[0];
    }

    // solution 3
    public int[] twoNumberSumV3(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];

            if (currentSum == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (currentSum < targetSum) {
                left++;
            } else if (currentSum > targetSum) {
                right--;
            }
        }
        return new int[0];
    }
}
