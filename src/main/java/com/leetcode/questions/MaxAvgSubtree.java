package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

/**
 * Given the root of a binary tree, find the maximum average value of
 * any subtree of that tree.
 * <p>
 * (A subtree of a tree is any node of that tree plus all its
 * descendants. The average value of a tree is the sum of its values,
 * divided by the number of nodes.)
 */
public class MaxAvgSubtree {
    public double maximumAverageSubtree(TreeNode root) {
        // sum, count, avg
        return dfs(root)[2];
    }

    private double[] dfs(TreeNode root) {
        if (root == null) return new double[]{0, 0, 0};
        double[] l = dfs(root.left);
        double[] r = dfs(root.right);
        double n = (l[1] + r[1] + 1);
        double sum = (l[0] + r[0] + root.val);
        double max = Math.max(Math.max(sum / n, l[2]), r[2]);
        return new double[]{sum, n, max};
    }
}
