package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubstrsWithConcatOfAllWordsTest {
    private SubstrsWithConcatOfAllWords underTest;

    @Before
    public void setUp() {
        underTest = new SubstrsWithConcatOfAllWords();
    }

    @Test
    public void test_1() {
        String s = "barfoothefoobarmanpotato";
        String[] words = new String[]{
                "foo", "bar"
        };

        assertThat(underTest.findSubstring(s, words)).contains(0, 9);
    }
}