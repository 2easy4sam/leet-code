package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MinTimeToCollectAllApples1443Test {
    private MinTimeToCollectAllApples1443 underTest;

    @Before
    public void setup() {
        underTest = new MinTimeToCollectAllApples1443();
    }

    @Test
    public void test_1() {
        int n = 7;
        int[][] edges = new int[][]{
                {0, 1},
                {0, 2},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 6}
        };
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);

        assertThat(underTest.minTime(n, edges, hasApple)).isEqualTo(8);
    }

    @Test
    public void test_2() {
        int n = 7;
        int[][] edges = new int[][]{
                {0, 1},
                {0, 2},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 6}
        };
        List<Boolean> hasApple = Arrays.asList(false, true, false, false, true, true, false);

        assertThat(underTest.minTime(n, edges, hasApple)).isEqualTo(8);
    }
}