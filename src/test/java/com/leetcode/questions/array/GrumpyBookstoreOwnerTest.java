package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrumpyBookstoreOwnerTest {
    private GrumpyBookstoreOwner grumpyBookstoreOwner;

    @Before
    public void setUp() {
        grumpyBookstoreOwner = new GrumpyBookstoreOwner();
    }

    @Test
    public void test_1() {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;

        assertThat(grumpyBookstoreOwner.maxSatisfied(customers, grumpy, X)).isEqualTo(16);
    }
}