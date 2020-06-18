package com.leetcode.questions;

import com.leetcode.datastructures.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode left = null, leftHead = null, right = null, rightHead = null;

        while (head != null) {
            if (head.val < x) {
                if (left == null) {
                    left = head;
                    leftHead = left;
                } else {
                    left.next = head;
                    left = left.next;
                }
            } else {
                if (right == null) {
                    right = head;
                    rightHead = right;
                } else {
                    right.next = head;
                    right = right.next;
                }
            }

            head = head.next;
        }

        if (right != null) right.next = null;
        if (left != null) left.next = rightHead;

        return leftHead == null ? rightHead : leftHead;
    }
}
