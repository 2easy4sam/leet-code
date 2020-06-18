package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthHappyStringTest {
    private KthHappyString kthHappyString;

    @Before
    public void setUp() {
        kthHappyString = new KthHappyString();
    }

    @Test
    public void test_1() {
        String str = kthHappyString.getHappyString(3, 9);

        assertThat(str).isEqualTo("cab");
    }
}