package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WordLadderIITest {
    private WordLadderII wordLadderII;

    @Before
    public void setUp() {
        wordLadderII = new WordLadderII();
    }

    @Test
    public void test_1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        assertThat(wordLadderII.findLadders(beginWord, endWord, words))
                .containsExactly(
                        Arrays.asList("hit", "hot", "dot", "dog", "cog"),
                        Arrays.asList("hit", "hot", "lot", "log", "cog")
                );
    }
}