package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

public class PlusOneLinkedListTest {
    private PlusOneLinkedList plusOneLinkedList;

    @Before
    public void setup() {
        plusOneLinkedList = new PlusOneLinkedList();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        plusOneLinkedList.plusOne(head);
    }

    @Test
    public void test_2() {
        ListNode head = new ListNode(9);
        head.next = new ListNode(8);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next.next.next = new ListNode(0);

        plusOneLinkedList.plusOne(head);
    }
}