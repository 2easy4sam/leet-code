package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

public class DiameterOfBinaryTree {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        // find the deepest leave in both left and right subtrees
        if (root == null) return 0;
        int dia = helper(root.left) + helper(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(ldia, rdia));
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        // find the deepest leave in both left and right subtrees
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
