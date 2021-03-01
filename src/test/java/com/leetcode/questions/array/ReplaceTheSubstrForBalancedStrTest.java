package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReplaceTheSubstrForBalancedStrTest {
    private ReplaceTheSubstrForBalancedStr replaceTheSubstrForBalancedStr;

    @Before
    public void setUp() {
        replaceTheSubstrForBalancedStr = new ReplaceTheSubstrForBalancedStr();
    }

    @Test
    public void test_1() {
        String s = "QWER";

        assertThat(replaceTheSubstrForBalancedStr.balancedString(s)).isEqualTo(0);
    }
}