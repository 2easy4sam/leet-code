package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

public class SparseMatrixMultiplicationTest {
    private SparseMatrixMultiplication underTest;

    @Before
    public void setUp() {
        underTest = new SparseMatrixMultiplication();
    }

    @Test
    public void test_1() {
        int[][] A = new int[][]{
                {1, -5}
        };

        int[][] B = new int[][]{
                {12},
                {-1}
        };

        underTest.multiply(A, B);
    }
}