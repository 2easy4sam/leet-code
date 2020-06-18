package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsMajorityElementTest {
    private IsMajorityElement isMajorityElement;

    @Before
    public void setUp() {
        isMajorityElement = new IsMajorityElement();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{2, 4, 5, 5, 5, 5, 5, 6, 6};
        int target = 5;

        assertThat(isMajorityElement.isMajorityElement(nums, target)).isTrue();
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{10, 100, 101, 101};
        int target = 101;

        assertThat(isMajorityElement.isMajorityElement(nums, target)).isFalse();
    }

    @Test
    public void test_3() {
        int[] nums = new int[]{438885258};
        int target = 786460391;

        assertThat(isMajorityElement.isMajorityElement(nums, target)).isFalse();
    }
}