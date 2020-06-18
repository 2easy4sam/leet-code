package com.leetcode.questions.dp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetSumTest {
    private TargetSum targetSum;

    @Before
    public void setUp() {
        targetSum = new TargetSum();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1000};
        int target = -1000;

        assertThat(targetSum.findTargetSumWays(nums, target)).isEqualTo(1);
    }
}