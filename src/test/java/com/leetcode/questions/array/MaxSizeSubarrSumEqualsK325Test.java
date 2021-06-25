package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxSizeSubarrSumEqualsK325Test {
    private MaxSizeSubarrSumEqualsK325 underTest;

    @Before
    public void setUp() {
        underTest = new MaxSizeSubarrSumEqualsK325();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 0, -1};
        int k = -1;

        assertThat(underTest.maxSubArrayLen(nums, k)).isEqualTo(2);
    }
}