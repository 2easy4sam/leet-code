package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSumSmallerTest {
    private ThreeSumSmaller threeSumSmaller;

    @Before
    public void setUp() {
        threeSumSmaller = new ThreeSumSmaller();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{-2, 0, 1, 4, 3, 2, 1, 6, 7, 3, -10, -4, 3, 9, -20};
        int target = 2;

        assertThat(threeSumSmaller.threeSumSmaller(nums, target)).isEqualTo(202);
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{-2, 0, 1, 3};
        int target = 2;

        assertThat(threeSumSmaller.threeSumSmaller(nums, target)).isEqualTo(2);
    }
}