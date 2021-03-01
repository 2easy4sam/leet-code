package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitAStringIntoMaxNumOfUniqueSubstrTest {
    private SplitAStringIntoMaxNumOfUniqueSubstr splitAStringIntoMaxNumOfUniqueSubstr;

    @Before
    public void setUp() {
        splitAStringIntoMaxNumOfUniqueSubstr = new SplitAStringIntoMaxNumOfUniqueSubstr();
    }

    @Test
    public void test_1() {
        assertThat(splitAStringIntoMaxNumOfUniqueSubstr.maxUniqueSplit("aba")).isEqualTo(2);
    }

    @Test
    public void test_2() {
        assertThat(splitAStringIntoMaxNumOfUniqueSubstr.maxUniqueSplit("ababccc")).isEqualTo(5);
    }
}