package com.sb.algorithms.algoexpert;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        if (str.length() == 1)
            return true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
