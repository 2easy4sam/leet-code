package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

public class GeneralizedAbbreviationTest {
    private GeneralizedAbbreviation generalizedAbbreviation;

    @Before
    public void setUp() {
        generalizedAbbreviation = new GeneralizedAbbreviation();
    }

    @Test
    public void test_1() {
        generalizedAbbreviation.generateAbbreviations("word");
    }

    @Test
    public void test_2() {
        generalizedAbbreviation.generateAbbreviations("apple");
    }
}