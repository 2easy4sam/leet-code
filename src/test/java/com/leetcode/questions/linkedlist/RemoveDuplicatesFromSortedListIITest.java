package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesFromSortedListIITest {
    private RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII;

    @Before
    public void setUp() {
        removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        head = removeDuplicatesFromSortedListII.deleteDuplicates(head);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(2);
        assertThat(head.next.next.val).isEqualTo(5);
    }

    @Test
    public void test_2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        head = removeDuplicatesFromSortedListII.deleteDuplicates(head);

        assertThat(head.val).isEqualTo(2);
        assertThat(head.next.val).isEqualTo(3);
    }

    @Test
    public void test_3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);

        head = removeDuplicatesFromSortedListII.deleteDuplicates(head);

        assertThat(head).isNull();
    }
}