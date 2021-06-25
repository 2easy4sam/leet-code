package com.leetcode.questions.bfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinCostToMakeAtLeastOneValidPathInGridTest {
    private MinCostToMakeAtLeastOneValidPathInGrid underTest;

    @Before
    public void setUp() {
        underTest = new MinCostToMakeAtLeastOneValidPathInGrid();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
                {2, 2, 2, 2}
        };

        assertThat(underTest.minCost(grid)).isEqualTo(3);
    }
}