package com.sb.algorithms.hexlet.concurrency.module0.e3;

import com.sb.algorithms.hexlet.concurrency.module0.e2.GraphNode;
import com.sb.algorithms.hexlet.concurrency.module0.e2.XOField;
import com.sb.algorithms.hexlet.concurrency.module0.e2.XOField.Figure;

import java.util.HashSet;
import java.util.Set;

import static com.sb.algorithms.hexlet.concurrency.module0.e2.XOField.Figure.X;
import static com.sb.algorithms.hexlet.concurrency.module0.e2.XOField.Figure.O;

public class GraphBuilder {
    public GraphNode build(final Figure currentFigure, final XOField currentField) {
        final Figure nextFigure = currentFigure == O ? X : O;
        final Set<GraphNode> children = new HashSet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) {
                    continue;
                }
                final XOField newField = new XOField(currentField);
                newField.setFigure(x, y, nextFigure);
                children.add(build(nextFigure, newField));
            }
        }
        return new GraphNode(currentField, children);
    }
}
