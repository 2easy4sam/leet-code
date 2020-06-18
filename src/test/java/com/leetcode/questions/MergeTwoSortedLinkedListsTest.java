package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;
import com.leetcode.questions.linkedlist.MergeTwoSortedLinkedLists;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeTwoSortedLinkedListsTest {
    private MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists;

    @Before
    public void setUp() {
        mergeTwoSortedLinkedLists = new MergeTwoSortedLinkedLists();
    }

    @Test
    public void test_1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode head = mergeTwoSortedLinkedLists.mergeTwoLists(l1, l2);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(1);
        assertThat(head.next.next.val).isEqualTo(2);
        assertThat(head.next.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.next.next.val).isEqualTo(4);
    }

    @Test
    public void test_2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(6);

        ListNode head = mergeTwoSortedLinkedLists.mergeTwoLists(l1, l2);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(1);
        assertThat(head.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.next.val).isEqualTo(6);
        assertThat(head.next.next.next.next.next.val).isEqualTo(8);
    }
}