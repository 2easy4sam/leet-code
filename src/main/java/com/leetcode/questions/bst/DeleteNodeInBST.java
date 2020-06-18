package com.leetcode.questions.bst;

import com.leetcode.datastructures.TreeNode;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            // find the bottom-left leaf of the immediate right node
            // if it exists
            if (root.right != null) {
                TreeNode curr = root.right;

                while (curr.left != null) {
                    curr = curr.left;
                }

                curr.left = root.left;
                return curr;
            }
            return root.left;
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);

        return root;
    }
}
