package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UncommonWordsFromTwoSentencesTest {
    private UncommonWordsFromTwoSentences uncommonWordsFromTwoSentences;

    @Before
    public void setUp() {
        uncommonWordsFromTwoSentences = new UncommonWordsFromTwoSentences();
    }

    @Test
    public void test_1() {
        String A = "this apple is sweet";
        String B = "this apple is sour";

        assertThat(uncommonWordsFromTwoSentences.uncommonFromSentences(A, B))
                .containsExactly("sweet", "sour");
    }
}