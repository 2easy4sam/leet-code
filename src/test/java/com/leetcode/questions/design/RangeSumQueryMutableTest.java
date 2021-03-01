package com.leetcode.questions.design;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RangeSumQueryMutableTest {
    @Test
    public void test_1() {
        int[] nums = new int[]{1, 3, 5};

        RangeSumQueryMutable underTest = new RangeSumQueryMutable(nums);

        assertThat(underTest.sumRange(0, 2)).isEqualTo(9);
        underTest.update(1, 2);
        assertThat(underTest.sumRange(0, 2)).isEqualTo(8);
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{7, 2, 7, 2, 0};

        RangeSumQueryMutable underTest = new RangeSumQueryMutable(nums);

        underTest.update(4, 6);
        underTest.update(0, 2);
        underTest.update(0, 9);
        assertThat(underTest.sumRange(4, 4)).isEqualTo(6);
        underTest.update(3, 8);
        assertThat(underTest.sumRange(0, 4)).isEqualTo(32);
        underTest.update(4, 1);
        assertThat(underTest.sumRange(0, 3)).isEqualTo(26);
        assertThat(underTest.sumRange(0, 4)).isEqualTo(27);
        underTest.update(0, 4);
    }
}