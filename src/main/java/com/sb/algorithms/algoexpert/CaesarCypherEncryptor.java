package com.sb.algorithms.algoexpert;

public class CaesarCypherEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        return str
                .chars()
                .map(ch -> CaesarCypherEncryptor.shiftChar(ch, key))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    // 97 122
    private static int shiftChar(final int letter, final int key) {
        int left = 96;
        int right = 122;
        int newPosition = letter + key;
        int charsCount = right - left;

        if (newPosition > right) {
            int rest = newPosition - right;
            int position = rest % charsCount;

            return left + position;
        }

        return newPosition;
    }
}
