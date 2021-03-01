package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean isEvenLevel = true;
        TreeNode prev = null;

        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- > 0) {
                root = q.poll();

                if (isEvenLevel) {
                    if (isEven(root.val)) return false;
                    if (prev != null && prev.val >= root.val) return false;
                } else {
                    if (!isEven(root.val)) return false;
                    if (prev != null && prev.val <= root.val) return false;
                }

                prev = root;

                if (root.left != null) q.offer(root.left);
                if (root.right != null) q.offer(root.right);
            }

            isEvenLevel = !isEvenLevel;
            prev = null;
        }

        return true;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}
