package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode current = head;

        while (current != null) {
            while (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }

            current = current.next;
        }

        return head.val == val ? head.next : head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        ListNode next = head.next;
        if (next != null && next.val == val) next = removeElements(next, val);
        head.next = next;
        removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
