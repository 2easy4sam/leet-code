package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LargestUniqueNumberTest {
    private LargestUniqueNumber largestUniqueNumber;

    @Before
    public void setUp() {
        largestUniqueNumber = new LargestUniqueNumber();
    }

    @Test
    public void test_1() {
        assertThat(largestUniqueNumber.largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1})).isEqualTo(8);
    }

    @Test
    public void test_2() {
        assertThat(largestUniqueNumber.largestUniqueNumber(new int[]{9, 9, 8, 8})).isEqualTo(-1);
    }

    @Test
    public void test_3() {
        assertThat(largestUniqueNumber.largestUniqueNumber(new int[]{99})).isEqualTo(99);
    }

    @Test
    public void test_4() {
        assertThat(largestUniqueNumber.largestUniqueNumber(new int[]{})).isEqualTo(-1);
    }

    @Test
    public void test_5() {
        assertThat(largestUniqueNumber.largestUniqueNumber(new int[]{10, 11, 10})).isEqualTo(11);
    }
}