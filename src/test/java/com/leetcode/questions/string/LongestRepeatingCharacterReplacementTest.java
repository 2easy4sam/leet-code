package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestRepeatingCharacterReplacementTest {
    private LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement;

    @Before
    public void setUp() {
        longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
    }

    @Test
    public void test_1() {
        int res = longestRepeatingCharacterReplacement.characterReplacement("CSCSJOANSSS", 4);

        assertThat(res).isEqualTo(8);
    }
}