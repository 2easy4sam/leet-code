package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwapNodesInPairsTest {
    private SwapNodesInPairs swapNodesInPairs;

    @Before
    public void setup() {
        swapNodesInPairs = new SwapNodesInPairs();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = swapNodesInPairs.swapPairs(head);

        assertThat(head.val).isEqualTo(2);
        assertThat(head.next.val).isEqualTo(1);
        assertThat(head.next.next.val).isEqualTo(4);
        assertThat(head.next.next.next.val).isEqualTo(3);
        assertThat(head.next.next.next.next).isNull();
    }
}