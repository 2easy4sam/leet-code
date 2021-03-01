package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecodeStringTest {
    private DecodeString decodeString;

    @Before
    public void setUp() {
        decodeString = new DecodeString();
    }

    @Test
    public void test_1() {
        String s = "3[a]2[bc]";

        assertThat(decodeString.decodeString(s)).isEqualTo("aaabcbc");
    }
}