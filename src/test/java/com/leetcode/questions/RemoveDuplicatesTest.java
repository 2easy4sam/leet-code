package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesTest {
    private RemoveDuplicates removeDuplicates;

    @Before
    public void setUp() {
        removeDuplicates = new RemoveDuplicates();
    }

    @Test
    public void test_1() {
        int[] arr = new int[]{1, 1, 2};
        int count = removeDuplicates.removeDuplicates2(arr);

        assertThat(arr).containsExactly(1, 2, 2);
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void test_2() {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int count = removeDuplicates.removeDuplicates2(arr);

        assertThat(arr).containsExactly(0, 1, 2, 3, 4, 2, 2, 3, 3, 4);
        assertThat(count).isEqualTo(5);
    }

    @Test
    public void test_3() {
        int[] arr = new int[]{1};
        int count = removeDuplicates.removeDuplicates2(arr);

        assertThat(arr).containsExactly(1);
        assertThat(count).isEqualTo(1);
    }
}