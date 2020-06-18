package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, root, k);
    }

    private boolean helper(TreeNode curr, TreeNode root, int k) {
        if (curr == null) return false;
        if (curr.val > k) {
            // traverse left
            helper(curr.left, root, k);
        }
        // curr.val <= k
        // we can go either left or right
        int diff = k - curr.val;
        TreeNode node = findNode(root, diff);
        if (node != null && node != curr) return true;
        return helper(curr.left, root, k) || helper(curr.right, root, k);
    }

    private TreeNode findNode(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        if (root.val > target) return findNode(root.left, target);
        return findNode(root.right, target);
    }
}
