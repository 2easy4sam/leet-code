package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountServersThatCommunicateTest {
    private CountServersThatCommunicate countServersThatCommunicate;

    @Before
    public void setUp() {
        countServersThatCommunicate = new CountServersThatCommunicate();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        assertThat(countServersThatCommunicate.countServers(grid)).isEqualTo(4);
    }
}