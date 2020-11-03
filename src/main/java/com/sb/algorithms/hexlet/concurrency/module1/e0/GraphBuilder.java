package com.sb.algorithms.hexlet.concurrency.module1.e0;

import com.sb.algorithms.hexlet.concurrency.module0.e2.GraphNode;
import com.sb.algorithms.hexlet.concurrency.module0.e2.XOField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sb.algorithms.hexlet.concurrency.module0.e2.XOField.Figure;

public class GraphBuilder {

    public GraphNode build(final Figure currentFigure,
                           final XOField currentField,
                           final int deepLevel) {
        if (deepLevel > 3) return new GraphNode(currentField, Set.of());
        final List<Thread> threads = new ArrayList<>();
        final Set<GraphNode> children = new HashSet<>();

        final Figure nextFigure = currentFigure == Figure.O ? Figure.X : Figure.O;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) continue;

                final XOField newField = new XOField(currentField);
                newField.setFigure(x, y, nextFigure);
                final Thread threadThatAddsChildren = new Thread(() -> children.add(build(nextFigure, newField, deepLevel + 1)));
                threadThatAddsChildren.start();
                threads.add(threadThatAddsChildren);
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (final InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return new GraphNode(currentField, children);
    }
}
