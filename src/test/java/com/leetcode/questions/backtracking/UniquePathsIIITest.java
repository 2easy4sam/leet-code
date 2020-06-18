package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniquePathsIIITest {
    private UniquePathsIII uniquePathsIII;

    @Before
    public void setUp() {
        uniquePathsIII = new UniquePathsIII();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        assertThat(uniquePathsIII.uniquePathsIII(grid)).isEqualTo(2);
    }
}