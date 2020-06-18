package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public ListNode reverseListR(ListNode head) {
        return reverseListR(head, null);
    }

    private ListNode reverseListR(ListNode curr, ListNode newHead) {
        if (curr == null) return newHead;
        ListNode next = curr.next;
        curr.next = newHead;
        return reverseListR(next, curr);
    }
}
