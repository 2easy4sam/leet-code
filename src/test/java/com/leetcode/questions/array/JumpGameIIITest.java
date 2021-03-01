package com.leetcode.questions.array;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JumpGameIIITest {
    private JumpGameIII jumpGameIII;

    @Before
    public void setUp() {
        jumpGameIII = new JumpGameIII();
    }

    @Test
    public void test_1() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;

        assertThat(jumpGameIII.canReach(arr, start)).isTrue();
    }
}