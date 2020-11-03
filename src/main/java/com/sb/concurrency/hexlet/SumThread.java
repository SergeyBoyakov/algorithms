package com.sb.concurrency.hexlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class SumThread extends Thread {
    private int[] toSum;
    private int result;

    public SumThread(final int[] toSum) {
        this.toSum = toSum;
    }

    @Override
    public void run() {
        result = 0;
        for (int value : toSum) {
            result += value;
        }
    }

    public int getResult() {
        return result;
    }
}
