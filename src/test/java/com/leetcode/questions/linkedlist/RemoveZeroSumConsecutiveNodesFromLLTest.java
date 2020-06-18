package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveZeroSumConsecutiveNodesFromLLTest {
    private RemoveZeroSumConsecutiveNodesFromLL removeZeroSumConsecutiveNodesFromLL;

    @Before
    public void setup() {
        removeZeroSumConsecutiveNodesFromLL = new RemoveZeroSumConsecutiveNodesFromLL();
    }

    @Test
    public void test_1() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);

        head = removeZeroSumConsecutiveNodesFromLL.removeZeroSumSublists(head);

        assertThat(head.val).isEqualTo(1);
    }

    @Test
    public void test_prefixSum_1() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(-2);

        head = removeZeroSumConsecutiveNodesFromLL.removeZeroSumSublistsPrefixSum(head);

        assertThat(head).isNull();
    }
}