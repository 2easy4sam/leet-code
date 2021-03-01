package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyPreorderSerializationOfBTTest {
    private VerifyPreorderSerializationOfBT underTest;

    @Before
    public void setUp() {
        underTest = new VerifyPreorderSerializationOfBT();
    }

    @Test
    public void test_1() {
        assertThat(underTest.isValidSerialization("9,#,#,1")).isFalse();
    }

    @Test
    public void test_2() {
        assertThat(underTest.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")).isTrue();
    }
}