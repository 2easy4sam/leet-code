package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

public class LexicographicallySmallestEquivalentStringTest {
    private LexicographicallySmallestEquivalentString lexicographicallySmallestEquivalentString;

    @Before
    public void setUp() {
        lexicographicallySmallestEquivalentString = new LexicographicallySmallestEquivalentString();
    }

    @Test
    public void test_1() {
        String A = "parker", B = "morris", S = "parser";

        Map<Character, Set<Character>> map = lexicographicallySmallestEquivalentString.smallestEquivalentString(A, B, S);
    }
}