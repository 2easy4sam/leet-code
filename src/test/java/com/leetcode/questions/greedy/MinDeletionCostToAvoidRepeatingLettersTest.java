package com.leetcode.questions.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinDeletionCostToAvoidRepeatingLettersTest {
    private MinDeletionCostToAvoidRepeatingLetters minDeletionCostToAvoidRepeatingLetters;

    @Before
    public void setUp() {
        minDeletionCostToAvoidRepeatingLetters = new MinDeletionCostToAvoidRepeatingLetters();
    }

    @Test
    public void test_1() {
        String s = "abaac";
        int[] cost = new int[]{1, 2, 3, 4, 5};

        assertThat(minDeletionCostToAvoidRepeatingLetters.minCost(s, cost)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        String s = "aaababbabababba";
        int[] cost = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        assertThat(minDeletionCostToAvoidRepeatingLetters.minCost(s, cost)).isEqualTo(4);
    }
}