package com.sb.algorithms.hexlet.concurrency.module0.e2;

import java.util.Set;

public class GraphNode {
    private final XOField node;
    private final Set<GraphNode> children; // possible next movies for current node

    public GraphNode(final XOField node, final Set<GraphNode> children) {
        this.node = node;
        this.children = children;
    }

    public XOField getNode() {
        return node;
    }

    public Set<GraphNode> getChildren() {
        return children;
    }
}
