package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonCharsTest {
    private CommonChars commonChars;

    @Before
    public void setUp() {
        commonChars = new CommonChars();
    }

    @Test
    public void test_withArrayOfEmptyStrings() {
        assertThat(commonChars.commonChars(new String[]{"", "", ""})).isEqualTo(Collections.emptyList());
    }

    @Test
    public void test_withArray_andSingleString() {
        assertThat(commonChars.commonChars(new String[]{"abc"})).containsExactly("a", "b", "c");
    }

    @Test
    public void test_1() {
        assertThat(commonChars.commonChars(new String[]{"bella", "label", "roller"})).containsExactly("e", "l", "l");
    }

    @Test
    public void test_2() {
        assertThat(commonChars.commonChars(new String[]{"cool", "lock", "cook"})).containsExactly("c", "o");
    }
}