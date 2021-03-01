package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

public class PacificAtlanticWaterFlowTest {
    private PacificAtlanticWaterFlow pacificAtlanticWaterFlow;

    @Before
    public void setUp() {
        pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
    }

    @Test
    public void test_1() {
        int[][] matrix = new int[][]{
                {1, 1, 1, 1, 1},
                {3, 2, 4, 4, 2},
                {2, 3, 4, 4, 2},
                {4, 4, 4, 4, 2},
                {4, 4, 4, 4, 2}
        };

        pacificAtlanticWaterFlow.pacificAtlantic(matrix);
    }
}