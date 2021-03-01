package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeSumOfSortedSubarraySumsTest {
    private RangeSumOfSortedSubarraySums rangeSumOfSortedSubarraySums;

    @Before
    public void setUp() {
        rangeSumOfSortedSubarraySums = new RangeSumOfSortedSubarraySums();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 5;

        assertThat(rangeSumOfSortedSubarraySums.rangeSum(nums, n, left, right)).isEqualTo(13);
    }
}