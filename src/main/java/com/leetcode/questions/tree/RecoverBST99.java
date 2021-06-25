package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

public class RecoverBST99 {
    private TreeNode node1, node2;

    /*
    - keynotes:
        - in order to find the misplaced nodes, we need to understand what is a BST and how to validate a BST
            - a node i is a valid BST
                - all of the nodes in the left branch of i MUST be smaller than i
                - all of the nodes in the right branch of i MUST be greater than i
    */
    public void recoverTree(TreeNode root) {
        while (!(validate(root.left, new TreeNode(Integer.MIN_VALUE), root, root, true) && validate(root.right, root, new TreeNode(Integer.MAX_VALUE), root, false))) {
            int tmp = node1.val;
            node1.val = node2.val;
            node2.val = tmp;
        }
    }

    private boolean validate(TreeNode curr, TreeNode min, TreeNode max, TreeNode prev, boolean isLeft) {
        if (curr == null) return true;
        if (isLeft && curr.val > prev.val) {
            node1 = prev;
            node2 = curr;
            return false;
        }
        if (!isLeft && curr.val < prev.val) {
            node1 = prev;
            node2 = curr;
            return false;
        }
        if (curr.val < min.val) {
            node1 = min;
            node2 = curr;
            return false;
        }
        if (curr.val > max.val) {
            node1 = max;
            node2 = curr;
            return false;
        }

        return validate(curr.left, min, curr, curr, true) && validate(curr.right, curr, max, curr, false);
    }
}
