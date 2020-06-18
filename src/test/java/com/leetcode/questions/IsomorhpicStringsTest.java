package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsomorhpicStringsTest {
    private IsomorhpicStrings isomorhpicStrings;

    @Before
    public void setUp() {
        isomorhpicStrings = new IsomorhpicStrings();
    }

    @Test
    public void test_1() {
        assertThat(isomorhpicStrings.isIsomorphic("egg", "add")).isTrue();
    }

    @Test
    public void test_2() {
        assertThat(isomorhpicStrings.isIsomorphic("ab", "aa")).isTrue();
    }

    @Test
    public void test_3() {
        assertThat(isomorhpicStrings.isIsomorphic("ab", "ca")).isFalse();
    }
}