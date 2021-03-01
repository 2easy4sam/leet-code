package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SentenceScreenFittingTest {
    private SentenceScreenFitting sentenceScreenFitting;

    @Before
    public void setUp() {
        sentenceScreenFitting = new SentenceScreenFitting();
    }

    @Test
    public void test_1() {
        String[] sentence = new String[]{"hello", "world"};
        int rows = 2, cols = 8;

        assertThat(sentenceScreenFitting.wordsTyping(sentence, rows, cols)).isEqualTo(1);
    }

    @Test
    public void test_2() {
        String[] sentence = new String[]{"a", "bcd", "e"};
        int rows = 3, cols = 6;

        assertThat(sentenceScreenFitting.wordsTyping(sentence, rows, cols)).isEqualTo(2);
    }
}