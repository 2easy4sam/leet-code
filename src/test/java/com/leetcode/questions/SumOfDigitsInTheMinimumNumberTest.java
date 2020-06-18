package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfDigitsInTheMinimumNumberTest {
    private SumOfDigitsInTheMinimumNumber sumOfDigitsInTheMinimumNumber;

    @Before
    public void setUp() {
        sumOfDigitsInTheMinimumNumber = new SumOfDigitsInTheMinimumNumber();
    }

    @Test
    public void test() {
        int[] arr = new int[]{99, 77, 33, 66, 55};

        int res = sumOfDigitsInTheMinimumNumber.sumOfDigits(arr);

        assertThat(res).isEqualTo(1);
    }

}