package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeKSortedListsTest {
    private MergeKSortedLists mergeKSortedLists;

    @Before
    public void setUp() {
        mergeKSortedLists = new MergeKSortedLists();
    }

    @Test
    public void test_1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode head = mergeKSortedLists.mergeKLists(new ListNode[]{l1, l2, l3});

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(1);
        assertThat(head.next.next.val).isEqualTo(2);
        assertThat(head.next.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.next.next.next.val).isEqualTo(5);
        assertThat(head.next.next.next.next.next.next.next.val).isEqualTo(6);
        assertThat(head.next.next.next.next.next.next.next.next).isNull();
    }

    @Test
    public void test_2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(2);

        ListNode head = mergeKSortedLists.mergeKLists(new ListNode[]{l1, l2});

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(2);
        assertThat(head.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.val).isEqualTo(4);
    }

    @Test
    public void test_3() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(3);

        ListNode head = mergeKSortedLists.mergeKLists(new ListNode[]{l1, l2});

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(1);
        assertThat(head.next.next.val).isEqualTo(2);
        assertThat(head.next.next.next.val).isEqualTo(3);
    }

    @Test
    public void test_4() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(7);

        ListNode head = mergeKSortedLists.mergeKLists(new ListNode[]{l1, l2});

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(2);
        assertThat(head.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.next.val).isEqualTo(5);
        assertThat(head.next.next.next.next.next.val).isEqualTo(6);
        assertThat(head.next.next.next.next.next.next.val).isEqualTo(7);
    }

}