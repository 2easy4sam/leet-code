package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

/**
 * TODO: do this after MergeTwoSortedLinkedLists
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int k = lists.length;

        for (int i = 1; i < k; i++) {
            ListNode head1 = lists[i - 1];
            ListNode head2 = lists[i];

            // pair-wise merging
            ListNode p1 = head1;
            ListNode p2 = head2;
            ListNode prev = null;

            while (p1 != null && p2 != null) {
                ListNode next1 = p1.next;
                prev = p2;
                ListNode next2 = p2.next;

                if (p1.val >= p2.val) {
                    while (p2.next != null && p1.val > p2.next.val) {
                        p2 = next2;
                        next2 = p2.next;
                    }
                    p1.next = next2;
                    p2.next = p1;
                    p1 = next1;
                    p2 = next2;
                } else {
                    while (p1.next != null && p2.val > p1.next.val) {
                        p1 = next1;
                        next1 = p1.next;
                    }
                    p2.next = next1;
                    p1.next = p2;
                    p1 = next1;
                    p2 = next2;
                }
            }

            // lists could be of diff lengths
            // merge the remaining nodes in
            if (p1 != null && prev != null) {
                if (prev.val <= p1.val) prev.next = p1;
                else {
                    p2 = head2;

                    while (p2.next != prev) p2 = p2.next;
                    prev.next = p1.next;
                    p1.next = prev;
                    p2.next = p1;
                }
            }

            // whichever is longer is to be taken
            int count1 = count(head1);
            int count2 = count(head2);
            lists[i] = count1 > count2 ? head1 : head2;

            if (head1 != null && p2 != null) {
                ListNode curr = lists[i];

                while (curr.next != null) curr = curr.next;
                curr.next = p2;
            }
        }

        return lists[k - 1];
    }

    private int count(ListNode head) {
        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }
}
