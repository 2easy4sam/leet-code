package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxWidthOfBT {

    /**
     * Given a binary tree, write a function to get the
     * maximum width of the given tree. The width of a
     * tree is the maximum width among all levels.
     * The binary tree has the same structure as
     * a full binary tree, but some nodes are null.
     * <p>
     * The width of one level is defined as the length
     * between the end-nodes (the leftmost and right most
     * non-null nodes in the level, where the null nodes
     * between the end-nodes are also counted into the length
     * calculation.
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int max = 0, start = 0, end = 0;
        Map<TreeNode, Integer> indexMap = new HashMap<>();
        indexMap.put(root, 1);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                root = q.poll();
                // index of the current node in the array
                int curIdx = indexMap.get(root);

                if (i == 0) start = curIdx;
                if (i == size - 1) end = curIdx;

                if (root.left != null) {
                    indexMap.put(root.left, curIdx * 2);
                    q.offer(root.left);
                }
                if (root.right != null) {
                    indexMap.put(root.right, curIdx * 2 + 1);
                    q.offer(root.right);
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
