package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShortestCompletingWordTest {
    private ShortestCompletingWord shortestCompletingWord;

    @Before
    public void setup() {
        shortestCompletingWord = new ShortestCompletingWord();
    }

    @Test
    public void test_1() {
        String s = "1s3 PSt";
        String[] words = new String[]{"step", "steps", "stripe", "stepple"};

        assertThat(shortestCompletingWord.shortestCompletingWord(s, words)).isEqualTo("steps");
    }
}