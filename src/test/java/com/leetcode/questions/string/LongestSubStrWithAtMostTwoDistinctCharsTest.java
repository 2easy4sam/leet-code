package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubStrWithAtMostTwoDistinctCharsTest {
    private LongestSubStrWithAtMostTwoDistinctChars longestSubStrWithAtMostTwoDistinctChars;

    @Before
    public void setUp() {
        longestSubStrWithAtMostTwoDistinctChars = new LongestSubStrWithAtMostTwoDistinctChars();
    }

    @Test
    public void test_1() {
        assertThat(longestSubStrWithAtMostTwoDistinctChars.lengthOfLongestSubstringTwoDistinct("sjjsjjddduu")).isEqualTo(6);
    }
}