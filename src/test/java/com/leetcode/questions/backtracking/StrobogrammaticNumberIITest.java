package com.leetcode.questions.backtracking;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrobogrammaticNumberIITest {
    private StrobogrammaticNumberII strobogrammaticNumberII;

    @Before
    public void setUp() {
        strobogrammaticNumberII = new StrobogrammaticNumberII();
    }

    @Test
    public void test_1() {
        assertThat(strobogrammaticNumberII.findStrobogrammatic(2))
                .contains("11", "69", "88", "96");
    }
}