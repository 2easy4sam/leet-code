package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;

        int i = 1;
        ListNode nodeBeforeSublistHead = null;
        ListNode sublistHead = null;

        if (m == 1) {
            // when m is 1
            nodeBeforeSublistHead = new ListNode(0);
            nodeBeforeSublistHead.next = head;
        }

        while (curr != null && i <= n) {
            ListNode next = curr.next;
            if (i + 1 == m) nodeBeforeSublistHead = curr;
            if (i == m && sublistHead == null) sublistHead = curr;
            if (i > m && i <= n) {
                sublistHead.next = next;
                curr.next = nodeBeforeSublistHead.next;
                nodeBeforeSublistHead.next = curr;
            }

            curr = next;
            i++;
        }

        return m == 1 ? nodeBeforeSublistHead.next : head;
    }
}
