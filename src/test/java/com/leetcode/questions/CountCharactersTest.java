package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountCharactersTest {
    private CountCharacters countCharacters;

    @Before
    public void setUp() {
        countCharacters = new CountCharacters();
    }

    @Test
    public void test_1() {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";

        assertThat(countCharacters.countCharacters(words, chars)).isEqualTo(6);
    }

    @Test
    public void test_2() {
        String[] words = new String[]{"hello","world","leetcode"};
        String chars = "welldonehoneyr";

        assertThat(countCharacters.countCharacters(words, chars)).isEqualTo(10);
    }
}