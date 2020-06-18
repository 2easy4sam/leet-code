package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniquePathsTest {
    private UniquePaths uniquePaths;

    @Before
    public void setUp() {
        uniquePaths = new UniquePaths();
    }

    @Test
    public void test_1() {
        assertThat(uniquePaths.uniquePaths(3, 2)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        assertThat(uniquePaths.uniquePaths(7, 3)).isEqualTo(28);
    }
}