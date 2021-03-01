package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

public class FindRelativeRanksTest {
    private FindRelativeRanks findRelativeRanks;

    @Before
    public void setUp() {
        findRelativeRanks = new FindRelativeRanks();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{5, 4, 3, 2, 1};

        findRelativeRanks.findRelativeRanks(nums);
    }
}