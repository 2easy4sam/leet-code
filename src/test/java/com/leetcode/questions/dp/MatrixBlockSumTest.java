package com.leetcode.questions.dp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixBlockSumTest {
    private MatrixBlockSum matrixBlockSum;

    @Before
    public void setUp() {
        matrixBlockSum = new MatrixBlockSum();
    }

    @Test
    public void test_1() {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int K = 1;

        assertThat(matrixBlockSum.matrixBlockSum(mat, K)).containsExactly(
                new int[]{12, 21, 16},
                new int[]{27, 45, 33},
                new int[]{24, 39, 28}
        );
    }
}