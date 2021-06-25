package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstrOfAllVowelsInOrder1839Test {
    private LongestSubstrOfAllVowelsInOrder1839 underTest;

    @Before
    public void setUp() {
        underTest = new LongestSubstrOfAllVowelsInOrder1839();
    }

    @Test
    public void test_1() {
        assertThat(underTest.longestBeautifulSubstring("aiaeioouaaeeiouuiuieeo")).isEqualTo(8);
    }
}