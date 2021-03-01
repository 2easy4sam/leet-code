package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeautifulArrangementTest {
    private BeautifulArrangement beautifulArrangement;

    @Before
    public void setUp() {
        beautifulArrangement = new BeautifulArrangement();
    }

    @Test
    public void test_1() {
        assertThat(beautifulArrangement.countArrangement(3)).isEqualTo(3);
    }
}