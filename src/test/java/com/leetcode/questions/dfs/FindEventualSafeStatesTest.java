package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindEventualSafeStatesTest {
    private FindEventualSafeStates underTest;

    @Before
    public void setUp() {
        underTest = new FindEventualSafeStates();
    }

    @Test
    public void test_1() {
        int[][] graph = new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        assertThat(underTest.eventualSafeNodes(graph)).containsExactly(2, 4, 5, 6);
    }
}