package com.sb.algorithms.random;

public class QueueWithTwoStacks<T> {
    IntStack left = new IntStack();
    IntStack right = new IntStack();

    public void enQueue(final int element) {
        left.push(element);
    }

    public int deQueue() {
        if (right.getSize() == 0) {
            while (left.getSize() > 0) {
                right.push(left.pop());
            }
        }

        return right.pop();
    }
}

class IntStack {
    private int[] array = new int[16];
    private int index = -1;

    public int getSize() {
        return index + 1;
    }

    public void push(final int element) {
        if (index == array.length - 1) {
            increaseArray();
        }
        array[++index] = element;
    }

    private void increaseArray() {
        int[] targetArray = new int[array.length * 2];
        System.arraycopy(array, 0, targetArray, 0, array.length);
        array = targetArray;
    }

    public int pop() {
        if (index > -1) {
            return array[index--];
        }
        throw new IndexOutOfBoundsException();
    }
}

