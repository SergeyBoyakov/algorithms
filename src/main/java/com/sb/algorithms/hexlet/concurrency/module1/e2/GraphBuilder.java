package com.sb.algorithms.hexlet.concurrency.module1.e2;

import com.sb.algorithms.hexlet.concurrency.module0.e2.GraphNode;
import com.sb.algorithms.hexlet.concurrency.module0.e2.XOField;
import com.sb.algorithms.hexlet.concurrency.module0.e2.XOField.Figure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class GraphBuilder {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public GraphNode build(final Figure currentFigure,
                           final XOField currentField,
                           final int deepLevel) {
        if (deepLevel > 4) return new GraphNode(currentField, Set.of());

        final List<Future> futures = new ArrayList<>();
        final Figure nextFigure = currentFigure == Figure.O ? Figure.X : Figure.O;
        final Set<GraphNode> children = new CopyOnWriteArraySet<>();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) {
                    continue;
                }

                final XOField newField = new XOField(currentField);
                newField.setFigure(x, y, nextFigure);
                final Future<?> future = EXECUTOR.submit(() -> build(nextFigure, newField, deepLevel + 1));
                futures.add(future);
            }
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (final InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return new GraphNode(currentField, children);
    }
}
