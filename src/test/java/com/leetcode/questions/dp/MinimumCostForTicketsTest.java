package com.leetcode.questions.dp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumCostForTicketsTest {
    private MinimumCostForTickets minimumCostForTickets;

    @Before
    public void setUp() {
        minimumCostForTickets = new MinimumCostForTickets();
    }

    @Test
    public void test_1() {
        int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] costs = new int[]{2, 7, 15};

        assertThat(minimumCostForTickets.mincostTickets(days, costs)).isEqualTo(9);
    }
}