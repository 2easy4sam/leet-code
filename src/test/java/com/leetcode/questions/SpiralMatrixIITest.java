package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMatrixIITest {
    private SpiralMatrixII spiralMatrixII;

    @Before
    public void setUp() {
        spiralMatrixII = new SpiralMatrixII();
    }

    @Test
    public void test_1() {
        int[][] matrix = spiralMatrixII.generateMatrix(3);

        assertThat(matrix[0]).containsExactly(1, 2, 3);
        assertThat(matrix[1]).containsExactly(8, 9, 4);
        assertThat(matrix[2]).containsExactly(7, 6, 5);
    }

    @Test
    public void test_2() {
        int[][] matrix = spiralMatrixII.generateMatrix(4);

        assertThat(matrix[0]).containsExactly(1, 2, 3, 4);
        assertThat(matrix[1]).containsExactly(12, 13, 14, 5);
        assertThat(matrix[2]).containsExactly(11, 16, 15, 6);
        assertThat(matrix[3]).containsExactly(10, 9, 8, 7);
    }

    @Test
    public void test_3() {
        int[][] matrix = spiralMatrixII.generateMatrix(1);

        assertThat(matrix[0]).containsExactly(1);
    }
}