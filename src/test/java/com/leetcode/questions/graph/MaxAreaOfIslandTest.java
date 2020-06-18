package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxAreaOfIslandTest {
    private MaxAreaOfIsland maxAreaOfIsland;

    @Before
    public void setUp() {
        maxAreaOfIsland = new MaxAreaOfIsland();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        assertThat(maxAreaOfIsland.maxAreaOfIsland(grid)).isEqualTo(4);
    }
}