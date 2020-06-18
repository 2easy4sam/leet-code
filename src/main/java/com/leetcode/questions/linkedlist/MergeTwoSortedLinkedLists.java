package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO: come up with a better solution (recursive preferably)
 */
public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Queue<ListNode> q = new LinkedList<>();

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                q.add(l2);
                l2 = l2.next;
            } else {
                q.add(l1);
                l1 = l1.next;
            }
        }

        while (l1 != null) {
            q.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            q.add(l2);
            l2 = l2.next;
        }

        ListNode head = q.poll();
        ListNode current = head;

        while (!q.isEmpty()) {
            ListNode node = q.poll();
            current.next = node;
            current = current.next;
        }

        return head;
    }
}
