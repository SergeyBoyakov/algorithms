package com.sb.algorithms.algoexpert;

public class FindClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {

        if (tree.value == target) {
            return target;
        }
        if (target > tree.value) {
            findClosestValueInBst(tree.right, target);
        }
        if (target < tree.value) {
            findClosestValueInBst(tree.left, target);
        }

        // Write your code here.
        return -1;
    }

    private static int closest(final int target, final int left, final int right) {
        return Math.min(target - left, target - right);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
