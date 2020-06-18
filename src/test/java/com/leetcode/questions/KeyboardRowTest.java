package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyboardRowTest {
    private KeyboardRow keyboardRow;

    @Before
    public void setUp() {
        keyboardRow = new KeyboardRow();
    }

    @Test
    public void test_1() {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};

        String[] res = keyboardRow.findWords(words);
        assertThat(res).containsExactly("Alaska", "Dad");
    }

    @Test
    public void test_2() {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};

        String[] res = keyboardRow.findWords2(words);
        assertThat(res).containsExactly("Alaska", "Dad");
    }
}