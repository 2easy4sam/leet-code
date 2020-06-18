package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseLinkedListIITest {
    private ReverseLinkedListII reverseLinkedListII;

    @Before
    public void setup() {
        reverseLinkedListII = new ReverseLinkedListII();
    }

    @Test
    public void test_1() {
        int m = 2, n = 4;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverseLinkedListII.reverseBetween(head, m, n);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.next.val).isEqualTo(4);
        assertThat(head.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.val).isEqualTo(2);
        assertThat(head.next.next.next.next.val).isEqualTo(5);
        assertThat(head.next.next.next.next.next).isNull();
    }

    @Test
    public void test_2() {
        int m = 1, n = 3;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head = reverseLinkedListII.reverseBetween(head, m, n);

        assertThat(head.val).isEqualTo(3);
        assertThat(head.next.val).isEqualTo(2);
        assertThat(head.next.next.val).isEqualTo(1);
        assertThat(head.next.next.next).isNull();
    }
}