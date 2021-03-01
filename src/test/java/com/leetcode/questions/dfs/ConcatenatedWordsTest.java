package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcatenatedWordsTest {
    private ConcatenatedWords concatenatedWords;

    @Before
    public void setup() {
        concatenatedWords = new ConcatenatedWords();
    }

    @Test
    public void test_1() {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};

        assertThat(concatenatedWords.findAllConcatenatedWordsInADict(words)).contains("catsdogcats", "dogcatsdog", "ratcatdogcat");
    }
}