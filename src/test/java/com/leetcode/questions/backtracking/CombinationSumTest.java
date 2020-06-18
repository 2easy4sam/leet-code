package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CombinationSumTest {
    private CombinationSum combinationSum;

    @Before
    public void setUp() {
        combinationSum = new CombinationSum();
    }

    @Test
    public void test_1() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;

        assertThat(combinationSum.combinationSum(candidates, target))
                .contains(
                        Arrays.asList(2, 2, 2, 2),
                        Arrays.asList(2, 3, 3),
                        Arrays.asList(3, 5)
                );
    }
}