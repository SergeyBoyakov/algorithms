package com.sb.algorithms.hexlet.concurrency.module0.e3;

import com.sb.algorithms.hexlet.concurrency.module0.e2.GraphNode;

public class GraphHelper {
    public static void show(final GraphNode node, final int level) {
        final StringBuilder sb = new StringBuilder();
        for (int c = 0; c < level * 7; c++) {
            sb.append(".");
        }
        sb.append("   ");
        final String space = sb.toString();
        final String nodeString = node.getNode().toString();
        final String updatedNodeString = nodeString.replace("\n", "\n" + space);
        System.out.println("\n");
        for (GraphNode child : node.getChildren()) {
            show(child, level + 1);
        }
    }

    public static int countNodes(final GraphNode node) {
        int count = 1;
        for (GraphNode child : node.getChildren()) {
            count = count + countNodes(child);
        }
        return count;
    }
}
