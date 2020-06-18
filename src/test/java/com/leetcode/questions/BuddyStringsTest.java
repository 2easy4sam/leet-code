package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuddyStringsTest {
    private BuddyStrings buddyStrings;

    @Before
    public void setUp() {
        buddyStrings = new BuddyStrings();
    }

    @Test
    public void test_1() {
        String A = "aaaaaaabc";
        String B = "aaaaaaacb";

        assertThat(buddyStrings.buddyStrings(A, B)).isTrue();
    }

    @Test
    public void test_2() {
        String A = "aa";
        String B = "aa";

        assertThat(buddyStrings.buddyStrings(A, B)).isTrue();
    }

    @Test
    public void test_3() {
        String A = "ab";
        String B = "ab";

        assertThat(buddyStrings.buddyStrings(A, B)).isFalse();
    }
}