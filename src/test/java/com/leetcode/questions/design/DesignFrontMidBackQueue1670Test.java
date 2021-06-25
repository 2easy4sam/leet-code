package com.leetcode.questions.design;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DesignFrontMidBackQueue1670Test {
    @Test
    public void test_1() {
        DesignFrontMidBackQueue1670 list = new DesignFrontMidBackQueue1670();

        list.pushFront(1);
        list.pushBack(2);
        list.pushMiddle(3);
        list.pushMiddle(4);

        assertThat(list.popFront()).isEqualTo(1);
        assertThat(list.popMiddle()).isEqualTo(3);
        assertThat(list.popMiddle()).isEqualTo(4);
        assertThat(list.popBack()).isEqualTo(2);
    }
}