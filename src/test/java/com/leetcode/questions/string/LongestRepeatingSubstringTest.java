package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestRepeatingSubstringTest {
    private LongestRepeatingSubstring longestRepeatingSubstring;

    @Before
    public void setUp() {
        longestRepeatingSubstring = new LongestRepeatingSubstring();
    }

    @Test
    public void test_1() {
        assertThat(longestRepeatingSubstring.longestRepeatingSubstring("aaaaa")).isEqualTo(4);
    }
}