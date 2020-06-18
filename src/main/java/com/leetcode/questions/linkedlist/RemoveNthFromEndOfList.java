package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

public class RemoveNthFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // very-slow pointer, slow pointer, fast pointer
        ListNode p1 = head, p2 = head, p3 = head;
        int i = 0, j = 0, k = 0;

        while (p3 != null && p3.next != null) {
            p2 = p2.next;

            for (int l = 0; l < 2; l++) {
                // next.next
                p3 = p3.next;
                if (p3 != null) k++;
            }

            j++;
        }

        int nthFromEnd = k - n + 1;

        if (j < nthFromEnd && nthFromEnd <= k) {
            // node is between mid and end
            while (j != nthFromEnd - 1) {
                p2 = p2.next;
                j++;
            }

            p2.next = p2.next.next;
        } else if (i < nthFromEnd && nthFromEnd <= j) {
            while (i != nthFromEnd - 1) {
                p1 = p1.next;
                i++;
            }

            p1.next = p1.next.next;
        } else {
            return head.next;
        }

        return head;
    }
}
