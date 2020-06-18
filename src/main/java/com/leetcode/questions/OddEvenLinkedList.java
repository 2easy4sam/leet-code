package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode second = odd.next;
        ListNode even = second;

        while (odd != null && even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        if (even != null) even.next = null;
        odd.next = second;

        return head;
    }
}
