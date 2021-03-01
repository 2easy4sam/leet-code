package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheMazeTest {
    private TheMaze theMaze;

    @Before
    public void setUp() {
        theMaze = new TheMaze();
    }

    @Test
    public void test_1() {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[] start = new int[]{0, 4};
        int[] dest = new int[]{4, 4};

        assertThat(theMaze.hasPath(maze, start, dest)).isTrue();
    }

    @Test
    public void test_2() {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[] start = new int[]{0, 4};
        int[] dest = new int[]{3, 2};

        assertThat(theMaze.hasPath(maze, start, dest)).isFalse();
    }
}