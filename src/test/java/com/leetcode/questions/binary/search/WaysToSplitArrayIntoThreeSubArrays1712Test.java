package com.leetcode.questions.binary.search;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WaysToSplitArrayIntoThreeSubArrays1712Test {
    private WaysToSplitArrayIntoThreeSubArrays1712 underTest;

    @Before
    public void setUp() {
        underTest = new WaysToSplitArrayIntoThreeSubArrays1712();
    }

    @Test
    public void test_1() {
        assertThat(underTest.waysToSplit(new int[]{1, 1, 1})).isEqualTo(1);
    }

    @Test
    public void test_2() {
        assertThat(underTest.waysToSplit(new int[]{1, 2, 3, 2, 1})).isEqualTo(2);
    }
}