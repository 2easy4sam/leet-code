package com.leetcode.questions.tree;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathSumIVTest {
    private PathSumIV pathSumIV;

    @Before
    public void setup() {
        pathSumIV = new PathSumIV();
    }

    @Test
    public void test_1() {
        int sum = pathSumIV.pathSum(new int[]{113, 215, 221, 314, 322, 337, 348});

        assertThat(sum).isEqualTo(45);
    }

    @Test
    public void test_2() {
        int sum = pathSumIV.pathSum(new int[]{113, 221});

        assertThat(sum).isEqualTo(4);
    }

    @Test
    public void test_3() {
        int sum = pathSumIV.pathSum(new int[]{113, 215, 221});

        assertThat(sum).isEqualTo(12);
    }
}