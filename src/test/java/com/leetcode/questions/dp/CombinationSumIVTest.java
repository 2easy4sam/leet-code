package com.leetcode.questions.dp;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationSumIVTest {
    private CombinationSumIV combinationSumIV;

    @Before
    public void setUp() {
        combinationSumIV = new CombinationSumIV();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;

        assertThat(combinationSumIV.combinationSum4(nums, target)).isEqualTo(7);
    }
}