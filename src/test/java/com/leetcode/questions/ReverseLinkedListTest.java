package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;
import com.leetcode.questions.linkedlist.ReverseLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseLinkedListTest {
    private ReverseLinkedList reverseLinkedList;

    @Before
    public void setUp() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode newHead = reverseLinkedList.reverseListR(head);

        assertThat(newHead.val).isEqualTo(3);
        assertThat(newHead.next.val).isEqualTo(2);
        assertThat(newHead.next.next.val).isEqualTo(1);
    }
}