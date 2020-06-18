package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find
 * the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while ((root != null || !stack.isEmpty())
                && k != 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                if (--k == 0) {
                    return root.val;
                }
            }

            root = root.right;
        }

        return -1;
    }
}
