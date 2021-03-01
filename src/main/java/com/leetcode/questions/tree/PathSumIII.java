package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

public class PathSumIII {
    private int cnt;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        cnt = 0;

        dfs(root.left, sum, root.val, root.val);
        dfs(root.right, sum, root.val, root.val);

        return cnt;
    }

    private void dfs(TreeNode node, int sum, int sumSoFar, int parent) {
        if (sumSoFar == sum) cnt++;
        if (sumSoFar - parent == sum) cnt++;
        if (node == null) return;

        // treating the current node as a root
        dfs(node.left, sum, sumSoFar - parent + node.val, node.val);
        dfs(node.right, sum, sumSoFar - parent + node.val, node.val);

        // accumulating the sum
        dfs(node.left, sum, sumSoFar + node.val, node.val);
        dfs(node.right, sum, sumSoFar + node.val, node.val);
    }
}
