package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToLowerCaseTest {
    private ToLowerCase toLowerCase;

    @Before
    public void setUp() {
        toLowerCase = new ToLowerCase();
    }

    @Test
    public void test() {
        String str = "Hello";

        String result = toLowerCase.toLowerCase(str);

        assertThat(result).isEqualTo(str.toLowerCase());
    }
}