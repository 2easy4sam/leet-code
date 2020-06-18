package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortArrayByParityTest {
    private SortArrayByParity sortArrayByParity;

    @Before
    public void setUp() {
        sortArrayByParity = new SortArrayByParity();
    }

    @Test
    public void test_even() {
        int[] A = new int[]{3, 1, 2, 4};

        int[] res = sortArrayByParity.sortArrayByParity(A);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test_odd() {
        int[] A = new int[]{9, 2, 3, 4, 1};

        int[] res = sortArrayByParity.sortArrayByParity(A);
        System.out.println(Arrays.toString(res));
    }
}