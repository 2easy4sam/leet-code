package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMatrixTest {
    private SpiralMatrix spiralMatrix;

    @Before
    public void setUp() {
        spiralMatrix = new SpiralMatrix();
    }

    @Test
    public void test_1() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = spiralMatrix.spiralOrder(matrix);

        assertThat(result).containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);
    }

    @Test
    public void test_2() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> result = spiralMatrix.spiralOrder(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
    }

    @Test
    public void test_3() {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        List<Integer> result = spiralMatrix.spiralOrder(matrix);

        assertThat(result).containsExactly(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
    }
}