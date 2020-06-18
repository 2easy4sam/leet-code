package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSumTest {
    private ThreeSum threeSum;

    @Before
    public void setup() {
        threeSum = new ThreeSum();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = threeSum.threeSum(nums);

        assertThat(res);
    }
}