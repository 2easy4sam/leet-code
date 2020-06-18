package com.leetcode.questions.backtracking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationIteratorTest {
    private CombinationIterator combinationIterator;

    @Test
    public void test_1() {
        String chars = "abc";
        int comboLen = 2;

        combinationIterator = new CombinationIterator(chars, comboLen);

        assertThat(combinationIterator.next()).isEqualTo("ab");
        assertThat(combinationIterator.hasNext()).isTrue();
        assertThat(combinationIterator.next()).isEqualTo("ac");
        assertThat(combinationIterator.hasNext()).isTrue();
        assertThat(combinationIterator.next()).isEqualTo("bc");
        assertThat(combinationIterator.hasNext()).isFalse();
    }
}