package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

public class TopKFrequentElementsTest {
    private TopKFrequentElements topKFrequentElements;

    @Before
    public void setUp() {
        topKFrequentElements = new TopKFrequentElements();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        topKFrequentElements.topKFrequent(nums, k);
    }
}