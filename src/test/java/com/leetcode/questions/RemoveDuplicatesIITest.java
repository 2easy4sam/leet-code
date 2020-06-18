package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesIITest {
    private RemoveDuplicatesII removeDuplicatesII;

    @Before
    public void setUp() {
        removeDuplicatesII = new RemoveDuplicatesII();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(1, 1, 2, 2, 3, 3);
        assertThat(res).isEqualTo(5);
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(0, 0, 1, 1, 2, 3, 3, 3, 3);
        assertThat(res).isEqualTo(7);
    }

    @Test
    public void test_3() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 4};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(0, 0, 1, 1, 2, 3, 4, 3, 4);
        assertThat(res).isEqualTo(7);
    }

    @Test
    public void test_4() {
        int[] nums = new int[]{};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(res).isEqualTo(0);
    }

    @Test
    public void test_5() {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(0, 1, 2, 3, 4, 5);
        assertThat(res).isEqualTo(6);
    }

    @Test
    public void test_6() {
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(res).isEqualTo(2);
    }

    @Test
    public void test_7() {
        int[] nums = new int[]{1};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(1);
        assertThat(res).isEqualTo(1);
    }

    @Test
    public void test_8() {
        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 3};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(1, 1, 2, 2, 3, 2, 3);
        assertThat(res).isEqualTo(5);
    }

    @Test
    public void test_9() {
        int[] nums = new int[]{1, 1, 1, 1, 2, 2};

        int res = removeDuplicatesII.removeDuplicates2(nums);

        assertThat(nums).containsExactly(1, 1, 2, 2, 2, 2);
        assertThat(res).isEqualTo(4);
    }
}