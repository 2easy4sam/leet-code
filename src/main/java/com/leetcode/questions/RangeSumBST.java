package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given the root node of a binary search tree, return the sum of
 * values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 */
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // Pre-order traversal
            if (node != null) {
                if (node.val >= L && node.val <= R) {
                    sum += node.val;
                }
                stack.push(node.right);
                stack.push(node.left);
            }
        }

        return sum;
    }

    public int rangeSumBSTR(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBSTR(root.right, L, R);
        else if (root.val > R) return rangeSumBSTR(root.left, L, R);

        return root.val + rangeSumBSTR(root.left, L, R) + rangeSumBSTR(root.right, L, R);
    }
}
