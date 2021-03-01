package com.leetcode.questions.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindPermutationTest {
    private FindPermutation findPermutation;

    @Before
    public void setUp() {
        findPermutation = new FindPermutation();
    }

    @Test
    public void test_1() {
        assertThat(findPermutation.findPermutation("DDIDDI"))
                .containsExactly(3, 2, 1, 6, 5, 4, 7);
    }
}