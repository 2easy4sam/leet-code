package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HasGroupsSizeXTest {
    private HasGroupsSizeX hasGroupsSizeX;

    @Before
    public void setUp() {
        hasGroupsSizeX = new HasGroupsSizeX();
    }

    @Test
    public void test_1() {
        int[] deck = new int[]{1};

        assertThat(hasGroupsSizeX.hasGroupsSizeX(deck)).isFalse();
    }

    @Test
    public void test_2() {
        int[] deck = new int[]{1, 1, 2, 2, 2, 2};

        assertThat(hasGroupsSizeX.hasGroupsSizeX(deck)).isTrue();
    }

    @Test
    public void test_3() {
        int[] deck = new int[]{1, 2, 3, 4, 4, 3, 2, 1};

        assertThat(hasGroupsSizeX.hasGroupsSizeX(deck)).isTrue();
    }

    @Test
    public void test_4() {
        int[] deck = new int[]{1, 1};

        assertThat(hasGroupsSizeX.hasGroupsSizeX(deck)).isTrue();
    }

    @Test
    public void test_5() {
        int[] deck = new int[]{1, 1, 1, 2, 2, 2, 3, 3};

        assertThat(hasGroupsSizeX.hasGroupsSizeX(deck)).isFalse();
    }
}