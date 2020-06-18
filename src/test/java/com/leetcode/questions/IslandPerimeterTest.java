package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IslandPerimeterTest {
    private IslandPerimeter islandPerimeter;

    @Before
    public void setUp() {
        islandPerimeter = new IslandPerimeter();
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};

        int perimeter = islandPerimeter.islandPerimeter(grid);

        assertThat(perimeter).isEqualTo(16);
    }
}