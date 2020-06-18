package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringIITest {
    private ReverseStringII reverseStringII;

    @Before
    public void setUp() {
        reverseStringII = new ReverseStringII();
    }

    @Test
    public void test_withKBeingLongerThanTheString() {
        String str = "abc";
        int k = 4;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("cba");
    }

    @Test
    public void test_withSingleCharacter() {
        String str = "a";
        int k = 1;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("a");
    }

    @Test
    public void test_withStringLengthBeing2K_plus1() {
        String str = "abcde";
        int k = 2;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("bacde");
    }

    @Test
    public void test_2() {
        String str = "abcdefg";
        int k = 3;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("cbadefg");
    }

    @Test
    public void test_withStringLengthBeingMultiplesOf2K() {
        String str = "abcdef";
        int k = 2;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("bacdfe");
    }

    @Test
    public void test_withStringLengthBeingTheSameAsK() {
        String str = "abcd";
        int k = 4;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("dcba");
    }

    @Test
    public void test_withKBeing1() {
        String str = "hello";
        int k = 1;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo(str);
    }

    @Test
    public void test_leetcode_1() {
        String str = "abcdefg";
        int k = 2;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("bacdfeg");
    }

    @Test
    public void test_leetcode_46() {
        String str = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;

        assertThat(reverseStringII.reverseStr(str, k)).isEqualTo("fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi");
    }
}