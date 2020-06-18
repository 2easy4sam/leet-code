package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClimbingStairsTest {
    private ClimbingStairs climbingStairs;

    @Before
    public void setUp() {
        climbingStairs = new ClimbingStairs();
    }

    @Test
    public void test_1() {
        assertThat(climbingStairs.climbStairsDP(4)).isEqualTo(5);
    }

    @Test
    public void test_2() {
        assertThat(climbingStairs.climbStairs(1)).isEqualTo(1);
    }

    @Test
    public void test_3() {
        assertThat(climbingStairs.climbStairs(2)).isEqualTo(2);
    }

    @Test
    public void test_4() {
        assertThat(climbingStairs.climbStairs(3)).isEqualTo(3);
    }

    @Test
    public void testDP_1() {
        final long startTime = System.currentTimeMillis();

        assertThat(climbingStairs.climbStairsDP(45)).isEqualTo(1836311903);

        System.out.println("DP Elapsed time: " + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void test_5() {
        final long startTime = System.currentTimeMillis();

        assertThat(climbingStairs.climbStairs(45)).isEqualTo(1836311903);

        System.out.println("Elapsed time: " + (System.currentTimeMillis() - startTime));
    }
}