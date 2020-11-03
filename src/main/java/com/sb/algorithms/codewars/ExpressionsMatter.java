package com.sb.algorithms.codewars;

import java.util.Arrays;

public class ExpressionsMatter {
    public static int expressionsMatter(int a, int b, int c) {
        // Your Code here... Happy Coding!
        int foo1 = a + b + c;
        int foo3 = a + b * c;
        int foo4 = (a + b) * c;
        int foo5 = a * b * c;
        int foo6 = a * b + c;
        int foo7 = a * (b + c);
        int[] resultArr = new int[]{foo1, foo3, foo4, foo5, foo6, foo7};

        return Arrays.stream(resultArr).max().orElse(0);
    }
}
