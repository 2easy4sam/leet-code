package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathWithMinEffortTest {
    private PathWithMinEffort pathWithMinEffort;

    @Before
    public void setUp() {
        pathWithMinEffort = new PathWithMinEffort();
    }

    @Test
    public void test_1() {
        int[][] heights = new int[][]{
                {1, 10, 6, 7, 9, 10, 4, 9}
        };

        assertThat(pathWithMinEffort.minimumEffortPath(heights)).isEqualTo(9);
    }
}