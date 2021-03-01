package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WordLadderTest {
    private WordLadder wordLadder;

    @Before
    public void setUp() {
        wordLadder = new WordLadder();
    }

    @Test
    public void test_1() {
        String beginWord = "hot";
        String endWord = "dog";
        String[] wordList = {"hot", "dog", "dot"};

        wordLadder.ladderLength(beginWord, endWord, Arrays.asList(wordList));
    }

    @Test
    public void test_2() {
        String beginWord = "qa";
        String endWord = "sq";
        String[] wordList = {"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};

        assertThat(wordLadder.ladderLength(beginWord, endWord, Arrays.asList(wordList))).isEqualTo(5);
    }
}