package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySubarraysWithSumTest {
    private BinarySubarraysWithSum binarySubarraysWithSum;

    @Before
    public void setUp() {
        binarySubarraysWithSum = new BinarySubarraysWithSum();
    }

    @Test
    public void test_1() {
        int[] arr = {1, 0, 1, 0, 1};
        int target = 2;

        assertThat(binarySubarraysWithSum.numSubarraysWithSum(arr, target)).isEqualTo(4);
    }
}