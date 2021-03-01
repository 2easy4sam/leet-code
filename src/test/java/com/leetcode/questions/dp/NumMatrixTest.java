package com.leetcode.questions.dp;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumMatrixTest {
    @Test
    public void test_with_square_matrix() {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        NumMatrix numMatrix = new NumMatrix(mat);

        assertThat(numMatrix.sumRegion(1, 1, 2, 2)).isEqualTo(28);
    }

    @Test
    public void test_with_rectangular_matrix() {
        int[][] mat = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };

        NumMatrix numMatrix = new NumMatrix(mat);

        assertThat(numMatrix.sumRegion(0, 0, 1, 1)).isEqualTo(1 + 2 + 5 + 6);
    }
}