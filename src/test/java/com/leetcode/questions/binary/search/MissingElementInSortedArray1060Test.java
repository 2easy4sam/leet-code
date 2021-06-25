package com.leetcode.questions.binary.search;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingElementInSortedArray1060Test {
    private MissingElementInSortedArray1060 underTest;

    @Before
    public void setUp() {
        underTest = new MissingElementInSortedArray1060();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{4, 7, 9, 10};
        int k = 2;

        assertThat(underTest.missingElement(nums, k)).isEqualTo(8);
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{2, 3, 5, 7};
        int k = 1;

        assertThat(underTest.missingElement(nums, k)).isEqualTo(4);
    }
}