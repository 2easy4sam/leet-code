package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RelativeArraySortTest {
    private RelativeArraySort relativeArraySort;

    @Before
    public void setUp() {
        relativeArraySort = new RelativeArraySort();
    }

    @Test
    public void test() {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = new int[]{2, 1, 4, 3, 9, 6};

        int[] res = relativeArraySort.relativeSortArray(arr1, arr2);

        assertThat(res).containsSequence(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19);
    }

    @Test
    public void test_2() {
        int[] arr1 = new int[]{28, 6, 22, 8, 44, 17}, arr2 = new int[]{22, 28, 8, 6};

        int[] res = relativeArraySort.relativeSortArray(arr1, arr2);

        assertThat(res).containsSequence(22, 28, 8, 6, 17, 44);
    }
}