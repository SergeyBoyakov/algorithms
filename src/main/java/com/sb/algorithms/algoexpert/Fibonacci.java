package com.sb.algorithms.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    /*
    Nth Fibonacci
    0 1 1 2 3 5
     */

    // O(2^n) time | O(n) space
    public int getNthFib(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            return getNthFib(n - 1) + getNthFib(n - 2);
        }
    }

    // O(n) time | O(n) space
    // Here we are using cache
    public int getNthFibV2(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 0);
        cache.put(2, 1);

        return getNthFibV2(n, cache);
    }

    private int getNthFibV2(int n, Map<Integer, Integer> memoize) {
        if (!memoize.containsKey(n)) {
            memoize.put(n, getNthFibV2(n - 1, memoize) + getNthFibV2(n - 2, memoize));
        }

        return memoize.get(n);
    }

    // O(n) time | O(1) space
    public int getNthFibV3(int n) {
        int[] lastTwo = {0, 1};
        int counter = 3;
        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];

            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;

            counter++;
        }

        return n > 1 ? lastTwo[1] : lastTwo[0];
    }
}
