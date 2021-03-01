package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideArrInSetsOfKConsecutiveNumsTest {
    private DivideArrInSetsOfKConsecutiveNums divideArrInSetsOfKConsecutiveNums;

    @Before
    public void setUp() {
        divideArrInSetsOfKConsecutiveNums = new DivideArrInSetsOfKConsecutiveNums();
    }

    @Test
    public void test_1() {
        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        int k = 3;

        assertThat(divideArrInSetsOfKConsecutiveNums.isPossibleDivide(nums, k)).isTrue();
    }
}