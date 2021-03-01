package com.leetcode.questions.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClosestDessertCostTest {
    private ClosestDessertCost underTest;

    @Before
    public void setUp() {
        underTest = new ClosestDessertCost();
    }

    @Test
    public void test_1() {
        int[] baseCosts = new int[]{3, 10};
        int[] toppingCosts = new int[]{2, 5};
        int target = 9;

        assertThat(underTest.closestCost(baseCosts, toppingCosts, target)).isEqualTo(8);
    }

    @Test
    public void test_2() {
        int[] baseCosts = new int[]{4052, 4139, 1056};
        int[] toppingCosts = new int[]{7319, 7048, 9000, 4100, 8870, 7200, 8816, 7428};
        int target = 179;

        assertThat(underTest.closestCost(baseCosts, toppingCosts, target)).isEqualTo(1056);
    }
}