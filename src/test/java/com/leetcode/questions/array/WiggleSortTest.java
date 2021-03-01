package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiggleSortTest {
    private WiggleSort wiggleSort;

    @Before
    public void setUp() {
        wiggleSort = new WiggleSort();
    }

    @Test
    public void test_wiggleSort1() {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort.wiggleSort(nums);

        assertThat(nums).containsExactly(3, 4, 2, 5, 1, 6);
    }

    @Test
    public void test_wiggleSort2() {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort.wiggleSort2(nums);

        assertThat(nums).containsExactly(3, 5, 1, 6, 2, 4);
    }
}