package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseOnlyLettersTest {
    private ReverseOnlyLetters reverseOnlyLetters;

    @Before
    public void setUp() {
        reverseOnlyLetters = new ReverseOnlyLetters();
    }

    @Test
    public void test_1() {
        String S = "Test1ng-Leet=code-Q!";

        assertThat(reverseOnlyLetters.reverseOnlyLetters(S)).isEqualTo("Qedo1ct-eeLg=ntse-T!");
    }
}