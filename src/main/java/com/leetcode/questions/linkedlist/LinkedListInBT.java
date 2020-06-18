package com.leetcode.questions.linkedlist;

import com.leetcode.datastructures.ListNode;
import com.leetcode.datastructures.TreeNode;

/**
 * Given a binary tree root and a linked list with head as the first
 * node.
 * <p>
 * Return True if all the elements in the linked list starting from
 * the head correspond to some downward path connected in the binary
 * tree otherwise return False.
 * <p>
 * In this context downward path means a path that starts at some
 * node and goes downwards.
 */
public class LinkedListInBT {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // 1. the path may be at the very bottom, which means
        // even if the nodes visited so far don't form the
        // path partially or fully, the algorithm should still
        // traverse deeper

        // 2. if the current node matches the head of path,
        // pass root.next and head.left AND root.next and head.right
        // to isSubPath

        // 3. if head == null AND root == null, it's a match
        if (head == null) return true;
        // head is not null but root is null
        if (root == null) return false;

        return dfs(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        // head is not null but root is null
        if (root == null) return false;

        return head.val == root.val
                && (dfs(head.next, root.left)
                || dfs(head.next, root.right));
    }
}
