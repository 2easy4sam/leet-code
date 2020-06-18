package com.leetcode.questions;

import com.leetcode.questions.JewelsAndStones;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JewelsAndStonesTest {

    private JewelsAndStones jewelsAndStones;

    @Before
    public void setUp() {
        jewelsAndStones = new JewelsAndStones();
    }

    @Test
    public void test_withOccurrences() {
        String s = "aAAbbbb";
        String j = "aA";

        assertThat(jewelsAndStones.solve(j, s)).isEqualTo(3);
    }

    @Test
    public void test_withNoOccurrences() {
        String s = "ZZ";
        String j = "z";

        assertThat(jewelsAndStones.solve(j, s)).isEqualTo(0);
    }
}