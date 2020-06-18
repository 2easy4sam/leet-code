package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstrWithoutRepeatingCharsTest {
    private LongestSubstrWithoutRepeatingChars longestSubstrWithoutRepeatingChars;

    @Before
    public void setUp() {
        longestSubstrWithoutRepeatingChars = new LongestSubstrWithoutRepeatingChars();
    }

    @Test
    public void test_1() {
        String s = "abcabcbb";

        assertThat(longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring(s)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        String s = "bbbbb";

        assertThat(longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring(s)).isEqualTo(1);
    }

    @Test
    public void test_3() {
        String s = "pwwkew";

        assertThat(longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring(s)).isEqualTo(3);
    }

    @Test
    public void test_4() {
        assertThat(longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring(null)).isEqualTo(0);
    }

    @Test
    public void test_5() {
        String s = "a";

        assertThat(longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring(s)).isEqualTo(1);
    }

    @Test
    public void test_6() {
        String s = "dvdf";

        assertThat(longestSubstrWithoutRepeatingChars.lengthOfLongestSubstring(s)).isEqualTo(3);
    }
}