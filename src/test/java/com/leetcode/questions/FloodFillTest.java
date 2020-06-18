package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FloodFillTest {
    private FloodFill floodFill;

    @Before
    public void setUp() {
        floodFill = new FloodFill();
    }

    @Test
    public void test_1() {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] actual = floodFill.floodFill(image, 1, 1, 2);

        assertThat(actual[0]).containsExactly(2, 2, 2);
        assertThat(actual[1]).containsExactly(2, 2, 0);
        assertThat(actual[2]).containsExactly(2, 0, 1);
    }

    @Test
    public void test_2() {
        int[][] image = new int[][]{
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] actual = floodFill.floodFillBFS(image, 0, 0, 2);

        assertThat(actual[0]).containsExactly(2, 2, 2);
        assertThat(actual[1]).containsExactly(2, 2, 2);
    }
}