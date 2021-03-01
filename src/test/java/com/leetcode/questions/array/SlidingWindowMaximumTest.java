package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

public class SlidingWindowMaximumTest {
    private SlidingWindowMaximum slidingWindowMaximum;

    @Before
    public void setUp() {
        slidingWindowMaximum = new SlidingWindowMaximum();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
        int k = 5;
        slidingWindowMaximum.maxSlidingWindow(nums, k);
    }
}