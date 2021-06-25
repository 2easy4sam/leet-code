package com.leetcode.questions.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallestStrWithGivenNum1663Test {
    private SmallestStrWithGivenNum1663 underTest;

    @Before
    public void setUp() {
        underTest = new SmallestStrWithGivenNum1663();
    }

    @Test
    public void test_1() {
        assertThat(underTest.getSmallestString(3, 27)).isEqualTo("aaz");
    }
}