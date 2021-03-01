package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationInStringTest {
    private PermutationInString permutationInString;

    @Before
    public void setUp() {
        permutationInString = new PermutationInString();
    }

    @Test
    public void test_1() {
        String s1 = "ab";
        String s2 = "eidbaooo";

        assertThat(permutationInString.checkInclusion(s1, s2)).isTrue();
    }
}