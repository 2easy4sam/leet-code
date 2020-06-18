package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterTilePossibilitiesTest {
    private LetterTilePossibilities letterTilePossibilities;

    @Before
    public void setUp() {
        letterTilePossibilities = new LetterTilePossibilities();
    }

    @Test
    public void test_1() {
        String s = "AAB";

        int nPossibilities = letterTilePossibilities.numTilePossibilities(s);

        assertThat(nPossibilities).isEqualTo(8);
    }

    @Test
    public void test_2() {
        String s = "AAABBC";

        int nPossibilities = letterTilePossibilities.numTilePossibilities(s);

        assertThat(nPossibilities).isEqualTo(188);
    }
}