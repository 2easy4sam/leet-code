package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxIncreaseToKeepCitySkylineTest {
    private MaxIncreaseToKeepCitySkyline maxIncreaseToKeepCitySkyline;

    @Before
    public void setUp() {
        maxIncreaseToKeepCitySkyline = new MaxIncreaseToKeepCitySkyline();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };

        int res = maxIncreaseToKeepCitySkyline.maxIncreaseKeepingSkyline(grid);
        assertThat(res).isEqualTo(35);
    }
}