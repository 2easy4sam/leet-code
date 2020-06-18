package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

/**
 * Given a binary tree, each node has value 0 or 1.
 * Each root-to-leaf path represents a binary number
 * starting with the most significant bit.
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1,
 * then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers
 * represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 */
public class SumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int val) {
        if (root == null) return 0;

        val = root.val | val << 1;

        if (root.left == null && root.right == null) return val;

        return helper(root.left, val) + helper(root.right, val);
    }
}
