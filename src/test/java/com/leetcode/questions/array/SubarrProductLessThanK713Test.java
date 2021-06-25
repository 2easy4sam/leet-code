package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubarrProductLessThanK713Test {
    private SubarrProductLessThanK713 underTest;

    @Before
    public void setUp() {
        underTest = new SubarrProductLessThanK713();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;

        assertThat(underTest.numSubarrayProductLessThanK(nums, k)).isEqualTo(8);
    }
}