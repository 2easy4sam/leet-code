package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCompressionTest {
    private StringCompression underTest;

    @Before
    public void setUp() {
        underTest = new StringCompression();
    }

    @Test
    public void test_1() {
        char[] chars = "aabbccc".toCharArray();
        assertThat(underTest.compress(chars)).isEqualTo(6);
    }
}