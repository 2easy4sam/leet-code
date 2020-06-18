package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

/**
 * Given the root of a binary tree, find the maximum value V for
 * which there exists different nodes A and B where
 * V = |A.val - B.val| and A is an ancestor of B.
 *
 * (A node A is an ancestor of B if either: any child of A is equal
 * to B, or any child of A is an ancestor of B.)
 */
public class MaxDiffBetweenNodeAndAncestor {
    private int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiff(root, root.val, root.val);
        return res;
    }

    private void maxAncestorDiff(TreeNode root, int min, int max) {
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        res = Math.max(max - min, res);

        if (root.left != null) maxAncestorDiff(root.left, min, max);
        if (root.right != null) maxAncestorDiff(root.right, min, max);
    }
}
