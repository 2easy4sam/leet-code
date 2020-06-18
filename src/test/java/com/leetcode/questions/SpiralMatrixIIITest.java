package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMatrixIIITest {
    private SpiralMatrixIII spiralMatrixIII;

    @Before
    public void setUp() {
        spiralMatrixIII = new SpiralMatrixIII();
    }

    @Test
    public void test_1() {
        int[][] res = spiralMatrixIII.spiralMatrixIII(1, 4, 0, 0);

        assertThat(res[0]).containsExactly(0, 0);
        assertThat(res[1]).containsExactly(0, 1);
        assertThat(res[2]).containsExactly(0, 2);
        assertThat(res[3]).containsExactly(0, 3);
    }

    @Test
    public void test_2() {
        int[][] res = spiralMatrixIII.spiralMatrixIII(5, 6, 1, 4);

        assertThat(res[0]).containsExactly(1, 4);
        assertThat(res[1]).containsExactly(1, 5);
        assertThat(res[2]).containsExactly(2, 5);
        assertThat(res[3]).containsExactly(2, 4);
        assertThat(res[4]).containsExactly(2, 3);
        assertThat(res[5]).containsExactly(1, 3);
        assertThat(res[6]).containsExactly(0, 3);
        assertThat(res[7]).containsExactly(0, 4);
        assertThat(res[8]).containsExactly(0, 5);
        assertThat(res[9]).containsExactly(3, 5);
        assertThat(res[10]).containsExactly(3, 4);
        assertThat(res[11]).containsExactly(3, 3);
        assertThat(res[12]).containsExactly(3, 2);
        assertThat(res[13]).containsExactly(2, 2);
        assertThat(res[14]).containsExactly(1, 2);
        assertThat(res[15]).containsExactly(0, 2);
        assertThat(res[16]).containsExactly(4, 5);
        assertThat(res[17]).containsExactly(4, 4);
        assertThat(res[18]).containsExactly(4, 3);
        assertThat(res[19]).containsExactly(4, 2);
        assertThat(res[20]).containsExactly(4, 1);
        assertThat(res[21]).containsExactly(3, 1);
        assertThat(res[22]).containsExactly(2, 1);
        assertThat(res[23]).containsExactly(1, 1);
        assertThat(res[24]).containsExactly(0, 1);
        assertThat(res[25]).containsExactly(4, 0);
        assertThat(res[26]).containsExactly(3, 0);
        assertThat(res[27]).containsExactly(2, 0);
        assertThat(res[28]).containsExactly(1, 0);
        assertThat(res[29]).containsExactly(0, 0);
    }

    @Test
    public void test_3() {
        int[][] res = spiralMatrixIII.spiralMatrixIII(1, 1, 0, 0);

        assertThat(res[0]).containsExactly(0, 0);
    }

    @Test
    public void test_4() {
        int[][] res = spiralMatrixIII.spiralMatrixIII(4, 1, 0, 0);

        assertThat(res[0]).containsExactly(0, 0);
        assertThat(res[1]).containsExactly(1, 0);
        assertThat(res[2]).containsExactly(2, 0);
        assertThat(res[3]).containsExactly(3, 0);
    }
}