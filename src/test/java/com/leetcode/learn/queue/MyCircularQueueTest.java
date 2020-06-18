package com.leetcode.learn.queue;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyCircularQueueTest {
    private MyCircularQueue myCircularQueue;

    @Test
    public void test_1() {
        myCircularQueue = new MyCircularQueue(3);

        assertThat(myCircularQueue.enQueue(1)).isTrue();
        assertThat(myCircularQueue.enQueue(2)).isTrue();
        assertThat(myCircularQueue.enQueue(3)).isTrue();
        assertThat(myCircularQueue.enQueue(4)).isFalse();
        assertThat(myCircularQueue.Rear()).isEqualTo(3);
        assertThat(myCircularQueue.isFull()).isTrue();
        assertThat(myCircularQueue.deQueue()).isTrue();
        assertThat(myCircularQueue.enQueue(4)).isTrue();
        assertThat(myCircularQueue.Rear()).isEqualTo(4);
    }

    @Test
    public void test_2() {
        myCircularQueue = new MyCircularQueue(6);

        assertThat(myCircularQueue.enQueue(6)).isTrue();
        assertThat(myCircularQueue.Rear()).isEqualTo(-1);
    }
}