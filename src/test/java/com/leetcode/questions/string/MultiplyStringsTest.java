package com.leetcode.questions.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplyStringsTest {
    private MultiplyStrings multiplyStrings;

    @Before
    public void setUp() {
        multiplyStrings = new MultiplyStrings();
    }

    @Test
    public void test_1() {
        String num1 = "123";
        String num2 = "456";

        assertThat(multiplyStrings.multiply(num1, num2)).isEqualTo("56088");
    }

    @Test
    public void test_2() {
        String num1 = "9999";
        String num2 = "1001";

        assertThat(multiplyStrings.multiply(num1, num2)).isEqualTo("10008999");
    }

    @Test
    public void test_3() {
        String num1 = "123456789";
        String num2 = "987654321";

        assertThat(multiplyStrings.multiply(num1, num2)).isEqualTo("121932631112635269");
    }

    @Test
    public void test_4() {
        String num = "76345936381236459534";

        assertThat(multiplyStrings.multiply(num, num)).isEqualTo("5828702001927804826239945726019219497156");
    }
}