package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumSubArrayTest {
    private MaximumSubArray maximumSubArray;

    @Before
    public void setUp() {
        maximumSubArray = new MaximumSubArray();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        assertThat(maximumSubArray.maxSubArray(nums)).isEqualTo(6);
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};

        assertThat(maximumSubArray.maxSubArray(nums)).isEqualTo(21);
    }

    @Test
    public void test_3() {
        int[] nums = new int[]{1, 2, 3, -2, 7};

        assertThat(maximumSubArray.maxSubArray(nums)).isEqualTo(11);
    }

    @Test
    public void test_4() {
        int[] nums = new int[]{1};

        assertThat(maximumSubArray.maxSubArray(nums)).isEqualTo(1);
    }

    @Test
    public void test_5() {
        int[] nums = new int[]{-2, -1};

        assertThat(maximumSubArray.maxSubArray(nums)).isEqualTo(-1);
    }
}