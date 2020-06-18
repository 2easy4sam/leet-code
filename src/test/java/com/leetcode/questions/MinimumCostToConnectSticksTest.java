package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumCostToConnectSticksTest {
    private MinimumCostToConnectSticks minimumCostToConnectSticks;

    @Before
    public void setUp() {
        minimumCostToConnectSticks = new MinimumCostToConnectSticks();
    }

    @Test
    public void test_2() {
        int cost = minimumCostToConnectSticks.connectSticks(new int[]{2, 4, 3});

        assertThat(cost).isEqualTo(14);
    }

    @Test
    public void test_1() {
        int cost = minimumCostToConnectSticks.connectSticks(new int[]{1, 8, 3, 5});

        assertThat(cost).isEqualTo(30);
    }
}