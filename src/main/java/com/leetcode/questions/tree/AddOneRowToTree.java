package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Given the root of a binary tree, then value v and depth d, you
 * need to add a row of nodes with value v at the given depth d.
 * The root node is at depth 1.
 * <p>
 * The adding rule is: given a positive integer depth d, for each NOT
 * null tree nodes N in depth d-1, create two tree nodes with value v
 * as N's left subtree root and right subtree root. And N's original
 * left subtree should be the left subtree of the new left subtree
 * root, its original right subtree should be the right subtree of the
 * new right subtree root. If depth d is 1 that means there is no
 * depth d-1 at all, then create a tree node with value v as the new
 * root of the whole original tree, and the original tree is the new
 * root's left subtree.
 */
public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return helper(root, null, true, 1, v, d);
    }

    private TreeNode helper(TreeNode curr,
                            TreeNode parent,
                            boolean isLeft,
                            int depth,
                            int v,
                            int d) {
        if (depth == d) {
            if (parent == null) {
                // root level
                TreeNode newRoot = new TreeNode(v);
                newRoot.left = curr;
                return newRoot;
            } else {
                TreeNode node = new TreeNode(v);

                if (isLeft) {
                    node.left = parent.left;
                    parent.left = node;
                } else {
                    node.right = parent.right;
                    parent.right = node;
                }
            }
        } else if (curr != null) {
            helper(curr.left, curr, true, depth + 1, v, d);
            helper(curr.right, curr, false, depth + 1, v, d);
        }

        return curr;
    }
}
