package com.sb.algorithms.hexlet.concurrency.module2.e1.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class GraphBuilder implements Callable<Set<GoField>> {

    private final ExecutorService executorService;

    private final Figure nextFigure;

    private final GoField currentField;

    private final int deepLevel;

    public GraphBuilder(
            final ExecutorService executorService,
            final Figure currentFigure,
            final GoField currentField,
            final int deepLevel) {
        this.executorService = executorService;
        this.nextFigure = currentFigure == Figure.WHITE ? Figure.BLACK : Figure.WHITE;
        this.currentField = currentField;
        this.deepLevel = deepLevel;
    }

    @Override
    public Set<GoField> call() throws Exception {
        // BEGIN (write your solution here) #1
        final List<Future<Set<GoField>>> resultFutures = new ArrayList<>();
        final Set<GoField> allStates = new CopyOnWriteArraySet<>();
        for (int y = 0; y < GoField.FIELD_SIZE; y++) {
            for (int x = 0; x < GoField.FIELD_SIZE; x++) {
                if (currentField.figures[x][y] != null) continue;

                final GoField newField = new GoField(currentField);
                newField.figures[x][y] = this.nextFigure;

                allStates.add(currentField);

                final GraphBuilder graphBuilder =
                        new GraphBuilder(executorService, nextFigure, currentField, deepLevel + 1);

//                if (isAsync()) {
                if (false) {
                    final Future<Set<GoField>> future = executorService.submit(graphBuilder);
                    resultFutures.add(future);
                } else {
                    allStates.addAll(graphBuilder.call());
                }
            }
        }
        if (!resultFutures.isEmpty()) {
            for (var future : resultFutures) {
                final Set<GoField> resultSet = future.get();
                allStates.addAll(resultSet);
            }
        }

        return allStates;
        // END #4
    }

    private boolean isAsync() {
        return deepLevel <= 2;
    }

    private boolean isCurrentFieldFinal() {
        for (Figure[] line : currentField.figures) {
            for (Figure f : line) {
                if (f == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
