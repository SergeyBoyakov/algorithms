package com.sb.algorithms.hexlet.concurrency.module2.e1;

import com.sb.algorithms.hexlet.concurrency.module0.e2.GraphNode;
import com.sb.algorithms.hexlet.concurrency.module0.e2.XOField;
import com.sb.algorithms.hexlet.concurrency.module0.e2.XOField.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class GraphBuilder implements Callable<GraphNode> {
    private ExecutorService executorService;
    private XOField currentField;
    private Figure nextFigure;
    private int deepLevel;

    public GraphBuilder(
            final ExecutorService executorService,
            final XOField currentField,
            final Figure currentFigure,
            final int deepLevel
    ) {
        this.executorService = executorService;
        this.currentField = currentField;
        this.nextFigure = currentFigure == Figure.O ? Figure.X : Figure.O;
        this.deepLevel = deepLevel;
    }

    @Override
    public GraphNode call() throws Exception {
        final List<Future<GraphNode>> graphNodeFutures = new ArrayList<>();
        final Set<GraphNode> children = new CopyOnWriteArraySet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) continue;

                final XOField newField = new XOField(currentField);
                newField.setFigure(x, y, nextFigure);
                final GraphBuilder graphBuilder = new GraphBuilder(executorService, currentField, nextFigure, deepLevel + 1);

                if (isAsync()) {
                    final Future<GraphNode> submittedGraphBuilder = executorService.submit(graphBuilder);
                    graphNodeFutures.add(submittedGraphBuilder);
                } else {
                    children.add(graphBuilder.call());
                }
            }
        }
        if (!graphNodeFutures.isEmpty()) {
            for (var future : graphNodeFutures) {
                try {
                    children.add(future.get());
                } catch (final InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return new GraphNode(currentField, children);
    }

    private boolean isAsync() {
        return deepLevel <= 3;
    }
}
