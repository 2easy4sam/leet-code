package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixCellsInDistanceOrderTest {
    private MatrixCellsInDistanceOrder matrixCellsInDistanceOrder;

    @Before
    public void setUp() {
        matrixCellsInDistanceOrder = new MatrixCellsInDistanceOrder();
    }

    @Test
    public void test_1() {
        int r = 0, c = 0;

        int[][] res = matrixCellsInDistanceOrder.allCellsDistOrder(1, 2, r, c);

        assertThat(getManhattanDistances(res, r, c))
                .containsExactly(0, 1);
    }

    @Test
    public void test_2() {
        int r = 0, c = 1;

        int[][] res = matrixCellsInDistanceOrder.allCellsDistOrder(2, 2, r, c);

        assertThat(getManhattanDistances(res, r, c))
                .containsExactly(0, 1, 1, 2);
    }

    @Test
    public void test_3() {
        int r = 1, c = 2;

        int[][] res = matrixCellsInDistanceOrder.allCellsDistOrder(2, 3, r, c);

        assertThat(getManhattanDistances(res, r, c))
                .containsExactly(0, 1, 1, 2, 2, 3);
    }

    private int[] getManhattanDistances(int[][] coordsArr, int r, int c) {
        int[] manhattanDistances = new int[coordsArr.length];

        for (int i = 0; i < coordsArr.length; i++) {
            int[] coords = coordsArr[i];
            manhattanDistances[i] = Math.abs(coords[0] - r) + Math.abs(coords[1] - c);
        }

        return manhattanDistances;
    }
}