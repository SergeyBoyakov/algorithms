package com.sb.concurrency.hexlet;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Kek {
    static class MaxFinder implements Callable<Integer> {

        private final Integer[] array;

        public MaxFinder(final Integer[] array) {
            this.array = array;
        }

        @Override
        public Integer call() {
            int result = Integer.MIN_VALUE;
            for (int element : array) {
                if (element > result) result = element;
            }

            return result;
        }
    }

}
