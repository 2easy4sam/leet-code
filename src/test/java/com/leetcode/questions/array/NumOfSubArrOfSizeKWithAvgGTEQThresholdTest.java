package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumOfSubArrOfSizeKWithAvgGTEQThresholdTest {
    private NumOfSubArrOfSizeKWithAvgGTEQThreshold numOfSubArrOfSizeKWithAvgGTEQThreshold;

    @Before
    public void setUp() {
        numOfSubArrOfSizeKWithAvgGTEQThreshold = new NumOfSubArrOfSizeKWithAvgGTEQThreshold();
    }

    @Test
    public void test_1() {
        int[] arr = new int[]{2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3, threshold = 4;

        assertThat(numOfSubArrOfSizeKWithAvgGTEQThreshold.numOfSubarrays(arr, k, threshold)).isEqualTo(3);
    }
}