package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

public class MakeTwoStringsAnagramTest {
    private MakeTwoStringsAnagram makeTwoStringsAnagram;

    @Before
    public void setUp() {
        makeTwoStringsAnagram = new MakeTwoStringsAnagram();
    }

    @Test
    public void test_1() {
        makeTwoStringsAnagram.minSteps("leetcode", "practice");
    }
}