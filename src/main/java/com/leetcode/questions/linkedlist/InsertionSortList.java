package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        // 1. starting from the nth element, where n > 0
        // compare its value with all leading nodes.
        // insert it at an index where
        // n.val > pointer.val && n.val <= pointer.next.val
        // 2. if there is only 1 element, then it's considered
        // sorted
        if (head == null || head.next == null) return head;

        ListNode p2 = head.next;

        while (p2 != null) {
            ListNode next = p2.next;
            ListNode curr = head;
            // node immediately before curr
            ListNode prev = null;

            // compare p2 with all nodes between head and itself
            while (curr != null && curr != p2) {
                if (curr.val > p2.val) {
                    // find the node immediately before p2
                    ListNode tmp = curr;
                    while (tmp.next != p2) {
                        tmp = tmp.next;
                    }

                    tmp.next = next;
                    // insert p2 before the node immediately before it
                    p2.next = curr;
                    if (prev != null) prev.next = p2;

                    if (p2.val < head.val) head = p2;
                    break;
                }

                prev = curr;
                curr = curr.next;
            }

            p2 = next;
        }

        return head;
    }
}
