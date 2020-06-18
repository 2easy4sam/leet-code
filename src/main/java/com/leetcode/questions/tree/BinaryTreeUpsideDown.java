package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // original right node -> new left node
        // original left node -> root
        // original root -> right node
        if (root == null || root.left == null) return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        TreeNode farRight = newRoot;
        while (farRight.right != null) {
            farRight = farRight.right;
        }

        farRight.left = root.right;

        if (root != newRoot) {
            root.left = null;
            root.right = null;
            farRight.right = root;
        }

        return newRoot;
    }
}
