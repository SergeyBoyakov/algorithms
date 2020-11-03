package com.sb.algorithms.algoexpert;

public class FindTheClosestValueInBst {
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        if (tree.value == target)
            return tree.value;

        BST left = tree.left;
        BST right = tree.right;

//        if (target > tree.value) {
//            current = tree.left;
//
//
//
//        }
        return -1;
    }

    private static int iter(final BST tree, final int target) {

        return 0;
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
