package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

public class ConvertSortedListToBST {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;

        // The mid-point is always the root
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode tHead = new TreeNode(slow.val);
        tHead.left = toBST(head, slow);
        tHead.right = toBST(slow.next, tail);

        return tHead;
    }
}
