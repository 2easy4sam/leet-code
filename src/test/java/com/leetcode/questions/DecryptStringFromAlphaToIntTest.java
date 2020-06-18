package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecryptStringFromAlphaToIntTest {
    private DecryptStringFromAlphaToInt decryptStringFromAlphaToInt;

    @Before
    public void setUp() {
        decryptStringFromAlphaToInt = new DecryptStringFromAlphaToInt();
    }

    @Test
    public void test_1() {
        String s = "10#11#12";

        assertThat(decryptStringFromAlphaToInt.freqAlphabets(s)).isEqualTo("jkab");
    }

    @Test
    public void test_2() {
        String s = "1326#";

        assertThat(decryptStringFromAlphaToInt.freqAlphabets(s)).isEqualTo("acz");
    }

    @Test
    public void test_3() {
        String s = "25#";

        assertThat(decryptStringFromAlphaToInt.freqAlphabets(s)).isEqualTo("y");
    }

    @Test
    public void test_4() {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";

        assertThat(decryptStringFromAlphaToInt.freqAlphabets(s)).isEqualTo("abcdefghijklmnopqrstuvwxyz");
    }
}