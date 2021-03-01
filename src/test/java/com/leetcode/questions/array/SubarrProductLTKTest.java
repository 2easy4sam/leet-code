package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubarrProductLTKTest {
    private SubarrProductLTK subarrProductLTK;

    @Before
    public void setUp() {
        subarrProductLTK = new SubarrProductLTK();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{10, 5, 2, 6};

        assertThat(subarrProductLTK.numSubarrayProductLessThanK(nums, 100)).isEqualTo(8);
        assertThat(subarrProductLTK.numSubarrayProductLessThanK(nums, 11)).isEqualTo(5);
        assertThat(subarrProductLTK.numSubarrayProductLessThanK(nums, 10)).isEqualTo(3);
        assertThat(subarrProductLTK.numSubarrayProductLessThanK(nums, 5)).isEqualTo(1);
    }
}