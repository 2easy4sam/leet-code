package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstMissingPositiveTest {
    private FirstMissingPositive firstMissingPositive;

    @Before
    public void setUp() {
        firstMissingPositive = new FirstMissingPositive();
    }

    @Test
    public void test_1() {
        assertThat(firstMissingPositive.firstMissingPositive(new int[]{0, 1, 2})).isEqualTo(3);
    }
}