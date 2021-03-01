package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestConsecutiveSubarrWithAbsDiffLTEQNTest {
    private LongestConsecutiveSubarrWithAbsDiffLTEQN longestConsecutiveSubarrWithAbsDiffLTEQN;

    @Before
    public void setUp() {
        longestConsecutiveSubarrWithAbsDiffLTEQN = new LongestConsecutiveSubarrWithAbsDiffLTEQN();
    }

    @Test
    public void test_1() {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;

        assertThat(longestConsecutiveSubarrWithAbsDiffLTEQN.longestSubarray(nums, limit))
                .isEqualTo(2);
    }
}