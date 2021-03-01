package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectingCitiesWithMinCostTest {
    private ConnectingCitiesWithMinCost connectingCitiesWithMinCost;

    @Before
    public void setUp() {
        connectingCitiesWithMinCost = new ConnectingCitiesWithMinCost();
    }

    @Test
    public void test_1() {
        int n = 4;
        int[][] connections = new int[][]{
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 3},
                {3, 4, 4}
        };

        assertThat(connectingCitiesWithMinCost.minimumCost(n, connections))
                .isEqualTo(7);
    }
}