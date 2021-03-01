package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WordBreakIITest {
    private WordBreakII wordBreakII;

    @Before
    public void setUp() {
        wordBreakII = new WordBreakII();
    }

    @Test
    public void test_1() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        assertThat(wordBreakII.wordBreak(s, wordDict));
    }

    @Test
    public void test_2() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        assertThat(wordBreakII.wordBreak(s, wordDict)).contains("cats and dog", "cat sand dog");
    }
}