package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseWordsInStringIIITest {
    private ReverseWordsInStringIII reverseWordsInStringIII;

    @Before
    public void setUp() {
        reverseWordsInStringIII = new ReverseWordsInStringIII();
    }

    @Test
    public void test_withEmptyString() {
        assertThat(reverseWordsInStringIII.reverseWords("")).isEqualTo("");
    }

    @Test
    public void test_withNoSpace() {
        String sentence = "Thisisonesentence";

        assertThat(reverseWordsInStringIII.reverseWords(sentence)).isEqualTo("ecnetnesenosisihT");
    }

    @Test
    public void test_withSpaces() {
        String sentence = "Hello world";

        assertThat(reverseWordsInStringIII.reverseWords(sentence)).isEqualTo("olleH dlrow");
    }
}