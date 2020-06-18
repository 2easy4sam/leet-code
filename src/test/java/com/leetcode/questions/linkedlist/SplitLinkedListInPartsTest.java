package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitLinkedListInPartsTest {
    private SplitLinkedListInParts splitLinkedListInParts;

    @Before
    public void setup() {
        splitLinkedListInParts = new SplitLinkedListInParts();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);

        int k = 5;

        ListNode[] res = splitLinkedListInParts.splitListToParts(head, k);

        assertThat(res[0].val).isEqualTo(1);
    }



    @Test
    public void test_2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        int k = 3;

        ListNode[] res = splitLinkedListInParts.splitListToParts(head, k);

        assertThat(res[0].val).isEqualTo(1);
    }
}