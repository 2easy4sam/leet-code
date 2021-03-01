package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CorrectABinaryTree {
    /*
    - intuition:
        - GIVEN that the invalid node's right child points to another node at the same depth but to the right of itself
          THEN we can use BFS, enqueueing from right to left
    */
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) return root;

        // cpr -> child-parent relationship
        Map<TreeNode, TreeNode> cpr = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        cpr.put(root, null);

        q.offer(root);
        boolean found = false;

        while (!q.isEmpty() && !found) {
            final int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.right != null) {
                    if (cpr.containsKey(node.right.right)) {
                        node.right = null;
                        found = true;
                        break;
                    }

                    cpr.put(node.right, node);
                    q.offer(node.right);
                }

                if (node.left != null) {
                    if (cpr.containsKey(node.left.right)) {
                        node.left = null;
                        found = true;
                        break;
                    }

                    cpr.put(node.left, node);
                    q.offer(node.left);
                }
            }
        }

        return root;
    }
}
