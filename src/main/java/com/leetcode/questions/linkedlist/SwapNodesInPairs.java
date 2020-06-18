package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its
 * head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes
 * itself may be changed.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode newHead = p2;
        ListNode prev = null;

        while (p1 != null && p2 != null) {
            p1.next = null;
            if (prev != null) {
                prev.next = p2;
            }
            prev = p1;

            ListNode tmp = p2.next;    // new p1
            p2.next = p1;
            p1 = tmp;
            if (p1 != null) p2 = p1.next;
        }

        return newHead;
    }
}
