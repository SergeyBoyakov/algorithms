package com.sb.algorithms.leetcode;

import com.sb.algorithms.hexlet.datastructures.ArrayList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        List<Integer> ints = new ArrayList<>();
        while (true) {
            int element = x % 10;
            ints.add(element);
            if(x % 10 == x) break;
            x /= 10;
        }
        for (int c = 0; c <= (ints.size() / 2) - 1; c++) {
            int left = ints.get(c);
            int right = ints.get(ints.size() - 1 - c);
            if(left != right) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(!isPalindrome(123));
    }
}
