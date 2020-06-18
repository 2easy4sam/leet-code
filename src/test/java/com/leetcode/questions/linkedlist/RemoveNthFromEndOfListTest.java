package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveNthFromEndOfListTest {
    private RemoveNthFromEndOfList removeNthFromEndOfList;

    @Before
    public void setUp() {
        removeNthFromEndOfList = new RemoveNthFromEndOfList();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        head = removeNthFromEndOfList.removeNthFromEnd(head, n);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(2);
        assertThat(head.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.val).isEqualTo(5);
    }
}