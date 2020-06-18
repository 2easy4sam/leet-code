package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestDistanceToCharTest {
    private ShortestDistanceToChar shortestDistanceToChar;

    @Before
    public void setUp() {
        shortestDistanceToChar = new ShortestDistanceToChar();
    }

    @Test
    public void test_1() {
        String s = "loveleetcode";
        char c = 'e';

        assertThat(shortestDistanceToChar.shortestToChar(s, c))
                .containsExactly(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0);
    }

    @Test
    public void test_2() {
        String s = "aaba";
        char c = 'b';

        assertThat(shortestDistanceToChar.shortestToChar(s, c))
                .containsExactly(2, 1, 0, 1);
    }
}