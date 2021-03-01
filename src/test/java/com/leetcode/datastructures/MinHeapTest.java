package com.leetcode.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinHeapTest {
    @Test
    public void test_1() {
        MinHeap minHeap = new MinHeap(4);
        minHeap.insert(10);
        minHeap.insert(30);
        minHeap.insert(20);
        minHeap.insert(400);

        assertThat(minHeap.remove()).isEqualTo(10);
        assertThat(minHeap.remove()).isEqualTo(20);
        assertThat(minHeap.remove()).isEqualTo(30);
        assertThat(minHeap.remove()).isEqualTo(400);

        minHeap.insert(50);

        assertThat(minHeap.remove()).isEqualTo(50);
    }

    @Test
    public void test_insert_in_reverse_order() {
        MinHeap minHeap = new MinHeap(5);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);

        assertThat(minHeap.remove()).isEqualTo(1);
        assertThat(minHeap.remove()).isEqualTo(2);
        assertThat(minHeap.remove()).isEqualTo(3);
        assertThat(minHeap.remove()).isEqualTo(4);
        assertThat(minHeap.remove()).isEqualTo(5);
    }
}