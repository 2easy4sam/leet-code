package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveLinkedListElementsTest {
    private RemoveLinkedListElements removeLinkedListElements;

    @Before
    public void setUp() {
        removeLinkedListElements = new RemoveLinkedListElements();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode newHead = removeLinkedListElements.removeElements(head, 6);

        assertThat(newHead.val).isEqualTo(1);
        assertThat(newHead.next.val).isEqualTo(2);
        assertThat(newHead.next.next.val).isEqualTo(3);
        assertThat(newHead.next.next.next.val).isEqualTo(4);
        assertThat(newHead.next.next.next.next.val).isEqualTo(5);
        assertThat(newHead.next.next.next.next.next).isNull();
    }

    @Test
    public void test_2() {
        ListNode head = new ListNode(1);

        ListNode newHead = removeLinkedListElements.removeElements(head, 1);

        assertThat(newHead).isNull();
    }

    @Test
    public void test_3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        ListNode newHead = removeLinkedListElements.removeElements(head, 1);

        assertThat(newHead).isNull();
    }

    @Test
    public void test_4_withValNotFound() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode newHead = removeLinkedListElements.removeElements(head, 4);

        assertThat(newHead.val).isEqualTo(1);
        assertThat(newHead.next.val).isEqualTo(2);
        assertThat(newHead.next.next.val).isEqualTo(3);
    }
}