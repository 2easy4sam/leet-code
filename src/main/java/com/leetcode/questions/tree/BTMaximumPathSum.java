package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

public class BTMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root, 0);
        return max;
    }

    private int helper(TreeNode root, int sumSoFar) {
        if (root == null) return 0;

        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;

        if (root.left != null) {
            sum += Math.max(Math.max(root.val, root.left.val), root.val + root.left.val);

            if (root.right != null) {
                sum = Math.max(sum, root.right.val + sum);
            }

            if (sum + sumSoFar > sum) sum += sumSoFar;

            leftSum = helper(root.left, sum);
        } else if (root.right != null) {
            sum += Math.max(Math.max(root.val, root.right.val), root.val + root.right.val);

            if (sum + sumSoFar > sum) sum += sumSoFar;
            rightSum = helper(root.right, sum);
        }

        if (sum > max) {
            max = sum;
        }

        return Math.max(leftSum, rightSum);
    }
}
