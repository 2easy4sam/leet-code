package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PascalTriangleIITest {
    private PascalTriangleII pascalTriangleII;

    @Before
    public void setUp() {
        pascalTriangleII = new PascalTriangleII();
    }

    @Test
    public void test_1() {
        List<Integer> row = pascalTriangleII.getRow(3);

        assertThat(row).containsExactly(1, 3, 3, 1);
    }

    @Test
    public void test_2() {
        List<Integer> row = pascalTriangleII.getRow(4);

        assertThat(row).containsExactly(1, 4, 6, 4, 1);
    }

    @Test
    public void test_3() {
        List<Integer> row = pascalTriangleII.getRow(1);

        assertThat(row).containsExactly(1, 1);
    }

    @Test
    public void test_4() {
        List<Integer> row = pascalTriangleII.getRow(0);

        assertThat(row).containsExactly(1);
    }

    @Test
    public void test_5() {
        List<Integer> row = pascalTriangleII.getRow(5);

        assertThat(row).containsExactly(1, 5, 10, 10, 5, 1);
    }
}