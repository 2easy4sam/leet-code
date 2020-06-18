package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomSortStringTest {
    private CustomSortString customSortString;

    @Before
    public void setUp() {
        customSortString = new CustomSortString();
    }

    @Test
    public void test_1() {
        String S = "cba", T = "aabbccdef";

        assertThat(customSortString.customSortString(S, T)).isEqualTo("ccbbaafed");
    }

    @Test
    public void test_2() {
        String S = "bac", T = "cabac";

        assertThat(customSortString.customSortString(S, T)).isEqualTo("baacc");
    }

    @Test
    public void test_3() {
        String S = "acb", T = "dddddd";

        assertThat(customSortString.customSortString(S, T)).isEqualTo(T);
    }

    @Test
    public void test_4() {
        String S = "abc", T = "aaaaaa";

        assertThat(customSortString.customSortString(S, T)).isEqualTo(T);
    }

    @Test
    public void test_5() {
        String S = "exv", T = "xwvee";

        assertThat(customSortString.customSortString(S, T)).isEqualTo("eexvw");
    }
}