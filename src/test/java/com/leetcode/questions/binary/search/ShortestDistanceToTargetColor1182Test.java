package com.leetcode.questions.binary.search;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestDistanceToTargetColor1182Test {
    private ShortestDistanceToTargetColor1182 underTest;

    @Before
    public void setUp() {
        underTest = new ShortestDistanceToTargetColor1182();
    }

    @Test
    public void test_1() {
        int[] colors = new int[]{1, 1, 2, 1, 3, 2, 2, 3, 3};
        int[][] queries = new int[][]{
                {1, 3}, {2, 2}, {6, 1}
        };

        assertThat(underTest.shortestDistanceColor(colors, queries)).containsExactly(3, 0, 3);
    }
}