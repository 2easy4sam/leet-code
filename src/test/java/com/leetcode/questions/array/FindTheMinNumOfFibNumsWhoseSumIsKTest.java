package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTheMinNumOfFibNumsWhoseSumIsKTest {
    private FindTheMinNumOfFibNumsWhoseSumIsK findTheMinNumOfFibNumsWhoseSumIsK;

    @Before
    public void setUp() {
        findTheMinNumOfFibNumsWhoseSumIsK = new FindTheMinNumOfFibNumsWhoseSumIsK();
    }

    @Test
    public void test_1() {
        assertThat(findTheMinNumOfFibNumsWhoseSumIsK.findMinFibonacciNumbers(19)).isEqualTo(3);
    }
}