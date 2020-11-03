package com.sb.algorithms.codewars;

/*
Clock shows 'h' hours, 'm' minutes and 's' seconds after midnight.

Your task is to make 'Past' function which returns time converted to milliseconds.

Example:
Past(0, 1, 1) == 61000
Input constraints: 0 <= h <= 23, 0 <= m <= 59, 0 <= s <= 59
 */
public class Clock {
    public static int past(final int h, final int m, final int s) {
        int hourMillis = h * 3600 * 1000;
        int minutesMillis = m * 60 * 1000;
        int milliseconds = s * 1000;

        return hourMillis + minutesMillis + milliseconds;
    }
}