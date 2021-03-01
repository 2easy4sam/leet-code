package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NetworkDelayTimeTest {
    private NetworkDelayTime networkDelayTime;

    @Before
    public void setUp() {
        networkDelayTime = new NetworkDelayTime();
    }

    @Test
    public void test_1() {
        int[][] times = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int N = 4, K = 2;

        assertThat(networkDelayTime.networkDelayTime(times, N, K)).isEqualTo(2);
    }
}