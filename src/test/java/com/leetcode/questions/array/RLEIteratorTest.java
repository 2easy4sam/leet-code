package com.leetcode.questions.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RLEIteratorTest {
    @Test
    public void test_1() {
        int[] arr = {3, 8, 0, 9, 2, 5};

        RLEIterator rleIterator = new RLEIterator(arr);

        assertThat(rleIterator.next(2)).isEqualTo(8);
        assertThat(rleIterator.next(1)).isEqualTo(8);
        assertThat(rleIterator.next(1)).isEqualTo(5);
        assertThat(rleIterator.next(2)).isEqualTo(-1);
    }
}