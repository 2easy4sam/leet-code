package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReorderListTest {
    private ReorderList reorderList;

    @Before
    public void setUp() {
        reorderList = new ReorderList();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reorderList.reorderList(head);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(4);
        assertThat(head.next.next.val).isEqualTo(2);
        assertThat(head.next.next.next.val).isEqualTo(3);
    }

    @Test
    public void test_2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList.reorderList(head);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(5);
        assertThat(head.next.next.val).isEqualTo(2);
        assertThat(head.next.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.next.val).isEqualTo(3);
    }
}