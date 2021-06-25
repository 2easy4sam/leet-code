package com.leetcode.questions.two.pointers;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductOfTwoRunLengthEncodedArrays1868Test {
    private ProductOfTwoRunLengthEncodedArrays1868 underTest;

    @Before
    public void setUp() {
        underTest = new ProductOfTwoRunLengthEncodedArrays1868();
    }

    @Test
    public void test_1() {
        int[][] encoded = new int[][]{
                {1, 1},
                {2, 1},
                {1, 1},
                {2, 1},
                {1, 1}
        };

        assertThat(underTest.findRLEArray(encoded, encoded)).containsExactly(
                Arrays.asList(1, 1),
                Arrays.asList(4, 1),
                Arrays.asList(1, 1),
                Arrays.asList(4, 1),
                Arrays.asList(1, 1)
        );
    }
}