package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingNumberTest {
    private MissingNumber missingNumber;

    @Before
    public void setUp() {
        missingNumber = new MissingNumber();
    }

    @Test
    public void test_1() {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};

        assertThat(missingNumber.missingNumber2(nums)).isEqualTo(8);
    }

    @Test
    public void test_2() {
        int[] nums = new int[]{0};

        assertThat(missingNumber.missingNumber2(nums)).isEqualTo(1);
    }

    @Test
    public void test_3() {
        int[] nums = new int[]{1};

        assertThat(missingNumber.missingNumber2(nums)).isEqualTo(0);
    }

    @Test
    public void test_4() {
        int[] nums = new int[]{0, 1, 2, 3};

        assertThat(missingNumber.missingNumber2(nums)).isEqualTo(4);
    }
}