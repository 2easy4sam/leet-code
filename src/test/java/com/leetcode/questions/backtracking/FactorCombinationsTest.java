package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

public class FactorCombinationsTest {
    private FactorCombinations factorCombinations;

    @Before
    public void setUp() {
        factorCombinations = new FactorCombinations();
    }

    @Test
    public void test_1() {
        factorCombinations.getFactors(80);
    }
}