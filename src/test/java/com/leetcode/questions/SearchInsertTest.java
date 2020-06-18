package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInsertTest {
    private SearchInsert searchInsert;

    @Before
    public void setUp() {
        searchInsert = new SearchInsert();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;

        assertThat(searchInsert.searchInsert(nums, target)).isEqualTo(2);
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;

        assertThat(searchInsert.searchInsert(nums, target)).isEqualTo(1);
    }

    @Test
    public void test_3() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;

        assertThat(searchInsert.searchInsert(nums, target)).isEqualTo(4);
    }

    @Test
    public void test_4() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 4;

        assertThat(searchInsert.searchInsert(nums, target)).isEqualTo(2);
    }
}