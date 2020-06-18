package com.leetcode.algorithms.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BucketSortTest {
    private BucketSort bucketSort;

    @Before
    public void setUp() {
        bucketSort = new BucketSort();
    }

    @Test
    public void test_arrayWithNoDuplicates() {
        int[] nums = new int[]{5, 4, 3, 2, 1};

        bucketSort.sort(nums, 10);

        assertThat(nums).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    public void test_arrayWithDuplicates() {
        int[] nums = new int[]{1, 3, 3, 2, 4, 1, 5};

        bucketSort.sort(nums, 5);

        assertThat(nums).containsExactly(1, 1, 2, 3, 3, 4, 5);
    }
}