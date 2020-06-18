package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OddEvenLinkedListTest {
    private OddEvenLinkedList oddEvenLinkedList;

    @Before
    public void setUp() {
        oddEvenLinkedList = new OddEvenLinkedList();
    }

    @Test
    public void test_withOddList() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);

        oddEvenLinkedList.oddEvenList(head);

        assertThat(head.val).isEqualTo(2);
        assertThat(head.next.val).isEqualTo(3);
        assertThat(head.next.next.val).isEqualTo(6);
        assertThat(head.next.next.next.val).isEqualTo(7);
        assertThat(head.next.next.next.next.val).isEqualTo(1);
        assertThat(head.next.next.next.next.next.val).isEqualTo(5);
        assertThat(head.next.next.next.next.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.next.next.next.next).isNull();
    }

    @Test
    public void test_withSingleNode() {
        ListNode head = new ListNode(1);

        oddEvenLinkedList.oddEvenList(head);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next).isNull();
    }

    @Test
    public void test_withEvenList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        oddEvenLinkedList.oddEvenList(head);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(2);
        assertThat(head.next.next).isNull();
    }
}