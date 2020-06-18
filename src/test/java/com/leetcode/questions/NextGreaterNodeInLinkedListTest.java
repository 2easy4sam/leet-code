package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextGreaterNodeInLinkedListTest {
    private NextGreaterNodeInLinkedList nextGreaterNodeInLinkedList;

    @Before
    public void setUp() {
        nextGreaterNodeInLinkedList = new NextGreaterNodeInLinkedList();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);

        int[] answer = nextGreaterNodeInLinkedList.nextLargerNodes(head);

        assertThat(answer).containsExactly(5, 5, 0);
    }

    @Test
    public void test_2() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        int[] answer = nextGreaterNodeInLinkedList.nextLargerNodes(head);

        assertThat(answer).containsExactly(7, 0, 5, 5, 0);
    }

    @Test
    public void test_3() {
        ListNode head = null;

        int[] answer = nextGreaterNodeInLinkedList.nextLargerNodes(head);

        assertThat(answer).isEmpty();
    }

    @Test
    public void test_4() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);

        int[] answer = nextGreaterNodeInLinkedList.nextLargerNodes(head);

        assertThat(answer).containsExactly(7, 9, 9, 9, 0, 5, 0, 0);
    }

}