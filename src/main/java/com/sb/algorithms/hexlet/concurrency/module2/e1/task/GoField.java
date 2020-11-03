package com.sb.algorithms.hexlet.concurrency.module2.e1.task;

import java.util.Arrays;

public class GoField {

    final static int FIELD_SIZE = 3;

    final Figure[][] figures = new Figure[FIELD_SIZE][FIELD_SIZE];

    GoField() {
    } // Standard constructor

    // BEGIN (write your solution here) Maybe you want to write a custom field constructor?
    GoField(final GoField goField) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                this.figures[x][y] = goField.figures[x][y];
            }
        }
    }

    // END

    @Override//Необходимо для работы Set.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoField goField = (GoField) o;

        return Arrays.deepEquals(figures, goField.figures);

    }

    @Override //Необходимо для работы Set.
    public int hashCode() {
        return Arrays.deepHashCode(figures);
    }

    @Override//Может поможет в отлове багов.
    public String toString() {
        return "GoField{" +
                "figures=" + Arrays.deepToString(figures) +
                '}';
    }
}
