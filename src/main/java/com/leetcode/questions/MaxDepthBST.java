package com.leetcode.questions;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int iterative(TreeNode root) {
        int depth = 0;

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                // number of nodes at the same level
                int nNodes = queue.size();

                for (int i = 0; i < nNodes; i++) {
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                // all nodes at this level have been popped out
                // and none of them have child nodes
                depth++;
            }
        }

        return depth;
    }

    public int recursive(TreeNode root) {
        return root == null ? 0 : Math.max(recursive(root.left), recursive(root.right)) + 1;
    }
}
