package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumOfStrsContainingAllThreeCharsTest {
    private NumOfStrsContainingAllThreeChars numOfStrsContainingAllThreeChars;

    @Before
    public void setUp() {
        numOfStrsContainingAllThreeChars = new NumOfStrsContainingAllThreeChars();
    }

    @Test
    public void test_1() {
        String s = "abcaaa";
        // [abc], [abca], [abcaa], [abcaaa], [bca], [bcaa], [bcaaa]

        assertThat(numOfStrsContainingAllThreeChars.numberOfSubstrings(s)).isEqualTo(7);
    }
}