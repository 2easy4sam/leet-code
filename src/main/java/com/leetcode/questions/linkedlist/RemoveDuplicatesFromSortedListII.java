package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        // slow and fast pointers
        ListNode p1 = head, p2 = head, dummy = new ListNode(0);
        // dummy always points to the node before the slow pointer
        dummy.next = head;

        while (p2 != null && p2.next != null) {
            ListNode prev = null;
            int n = 0;
            while (p2.next != null && (p2.val == p2.next.val || p1.val == p2.val)) {
                prev = p2;
                p2 = p2.next;
                n++;
            }

            // at this point, p2.val should be different from p1.val
            if (prev != null && prev.val == p2.val) {
                // move p1 until p1.next == p2.val
                while (p1.next.val != p2.val) {
                    p1 = p1.next;
                }

                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p2;
            }

            if (prev != null && dummy.next.val == prev.val && n > 1) dummy.next = p2;
            else if (p2 != null && dummy.next.val == p2.val) dummy.next = p2.next;
        }

        return dummy.next;
    }
}
