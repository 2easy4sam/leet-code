package com.leetcode.questions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthLargestTest {
    private KthLargest kthLargest;

    @Test
    public void setUp() {
        int k = 3;
        int[] nums = new int[]{4, 5, 8, 2};

        kthLargest = new KthLargest(k, nums);

        assertThat(kthLargest.add(3)).isEqualTo(4);
        assertThat(kthLargest.add(5)).isEqualTo(5);
        assertThat(kthLargest.add(10)).isEqualTo(5);
        assertThat(kthLargest.add(9)).isEqualTo(8);
        assertThat(kthLargest.add(4)).isEqualTo(8);
    }
}