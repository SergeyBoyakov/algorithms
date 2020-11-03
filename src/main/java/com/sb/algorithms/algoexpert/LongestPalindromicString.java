package com.sb.algorithms.algoexpert;

public class LongestPalindromicString {

    public static String longestPalindromicSubstring(final String str) {
        if (str.length() == 0 || str.length() == 1) {
            return str;
        }

        String candidate = "";
        int maxLength = 2;
        for (int i = 0; i < str.length(); i++) {
            int startIndex = i;
            int end = maxLength / 2;

            while ((startIndex + end) * 2 < str.length() - 1) {
                String substring = str.substring(startIndex, (startIndex + end) * 2 + 1);
                if (isPalindromicString(substring)) {
                    end++;
                    maxLength = (startIndex + end) * 2;
                    candidate = substring;
                } else
                    break;
            }

        }

        return candidate;
    }

    private static boolean isPalindromicString(final String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(0) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
