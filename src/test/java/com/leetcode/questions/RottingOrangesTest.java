package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RottingOrangesTest {
    private RottingOranges rottingOranges;

    @Before
    public void setUp() {
        rottingOranges = new RottingOranges();
    }

    @Test
    public void test_1() {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        int minutes = rottingOranges.orangesRotting(grid);

        assertThat(minutes).isEqualTo(-1);
    }

    @Test
    public void test_2() {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int minutes = rottingOranges.orangesRotting(grid);

        assertThat(minutes).isEqualTo(4);
    }

    @Test
    public void test_3() {
        int[][] grid = new int[][]{
                {0, 2}
        };

        int minutes = rottingOranges.orangesRotting(grid);

        assertThat(minutes).isEqualTo(0);
    }

    @Test
    public void test_4() {
        int[][] grid = new int[][]{
                {1},
                {1},
                {1},
                {1}
        };

        int minutes = rottingOranges.orangesRotting(grid);

        assertThat(minutes).isEqualTo(-1);
    }

    @Test
    public void test_5() {
        int[][] grid = new int[][]{
                {0}
        };

        int minutes = rottingOranges.orangesRotting(grid);

        assertThat(minutes).isEqualTo(0);
    }

    @Test
    public void test_6() {
        int[][] grid = new int[][]{
                {2},
                {2},
                {1},
                {0},
                {1},
                {1}
        };

        int minutes = rottingOranges.orangesRotting(grid);

        assertThat(minutes).isEqualTo(-1);
    }
}