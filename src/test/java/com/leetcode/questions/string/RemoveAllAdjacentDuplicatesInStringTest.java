package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveAllAdjacentDuplicatesInStringTest {
    private RemoveAllAdjacentDuplicatesInString removeAllAdjacentDuplicatesInString;

    @Before
    public void setup() {
        removeAllAdjacentDuplicatesInString = new RemoveAllAdjacentDuplicatesInString();
    }

    @Test
    public void test_1() {
        assertThat(removeAllAdjacentDuplicatesInString.removeDuplicates("abcd", 2)).isEqualTo("abcd");
    }
}