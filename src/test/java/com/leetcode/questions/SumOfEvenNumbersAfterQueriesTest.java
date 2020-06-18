package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfEvenNumbersAfterQueriesTest {
    private SumOfEvenNumbersAfterQueries sumOfEvenNumbersAfterQueries;

    @Before
    public void setUp() {
        sumOfEvenNumbersAfterQueries = new SumOfEvenNumbersAfterQueries();
    }

    @Test
    public void test_1() {
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};

        int[] answers = sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(A, queries);

        assertThat(answers).containsExactly(8, 6, 2, 4);
    }
}