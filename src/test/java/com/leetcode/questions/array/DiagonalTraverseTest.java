package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiagonalTraverseTest {
    private DiagonalTraverse diagonalTraverse;

    @Before
    public void setUp() {
        diagonalTraverse = new DiagonalTraverse();
    }

    @Test
    public void test_1() {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        assertThat(diagonalTraverse.findDiagonalOrder(mat))
                .containsExactly(1, 2, 4, 7, 5, 3, 6, 8, 9);
    }
}