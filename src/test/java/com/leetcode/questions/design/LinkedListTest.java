package com.leetcode.questions.design;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {
    @Test
    public void test_1() {
        LinkedList ll = new LinkedList();
        ll.addAtHead(7);
        ll.addAtHead(2);
        ll.addAtHead(1);
        ll.addAtIndex(3, 0);
        ll.deleteAtIndex(2);
        ll.addAtHead(6);
        ll.addAtTail(4);
        assertThat(ll.get(4)).isEqualTo(4);
    }
}