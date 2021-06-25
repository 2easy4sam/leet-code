package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSum5Test {
    private TwoSum5 underTest;

    @Before
    public void setUp() {
        underTest = new TwoSum5();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{7, 2, 11, 15};
        int target = 24;

        assertThat(underTest.twoSum5(nums, target)).isEqualTo(5);
    }
}