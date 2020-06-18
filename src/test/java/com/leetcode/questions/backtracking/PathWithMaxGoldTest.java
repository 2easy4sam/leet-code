package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathWithMaxGoldTest {
    private PathWithMaxGold pathWithMaxGold;

    @Before
    public void setUp() {
        pathWithMaxGold = new PathWithMaxGold();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };

        int max = pathWithMaxGold.getMaximumGold(grid);

        assertThat(max).isEqualTo(24);
    }
}