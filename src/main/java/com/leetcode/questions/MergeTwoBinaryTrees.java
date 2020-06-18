package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        Queue<TreeNode> queue3 = new LinkedList<>();

        queue1.add(t1);
        queue2.add(t2);

        TreeNode root = new TreeNode(0);

        queue3.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            int size = Math.max(queue1.size(), queue2.size());

            for (int i = 0; i < size; i++) {
                boolean hasLeft = false;
                boolean hasRight = false;
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                TreeNode node3 = queue3.poll();

                // both node1 and node2 are null
                if (node1 == null && node2 == null) {
                    continue;
                } else {
                    if (node1 != null) {
                        if (node1.left != null) {
                            hasLeft = true;
                        }

                        if (node1.right != null) {
                            hasRight = true;
                        }

                        queue1.add(node1.left);
                        queue1.add(node1.right);
                    } else {
                        queue1.add(null);
                        queue1.add(null);
                    }

                    if (node2 != null) {
                        if (node2.left != null) {
                            hasLeft = true;
                        }

                        if (node2.right != null) {
                            hasRight = true;
                        }

                        queue2.add(node2.left);
                        queue2.add(node2.right);
                    } else {
                        queue2.add(null);
                        queue2.add(null);
                    }

                    if (node3 != null) {
                        node3.val = zeroOrVal(node1) + zeroOrVal(node2);

                        queue3.add(hasLeft ? node3.left = new TreeNode(0) : null);
                        queue3.add(hasRight ? node3.right = new TreeNode(0) : null);
                    } else {
                        queue3.add(null);
                        queue3.add(null);
                    }
                }
            }
        }

        return root;
    }

    private int zeroOrVal(TreeNode node) {
        return node == null ? 0 : node.val;
    }
}
