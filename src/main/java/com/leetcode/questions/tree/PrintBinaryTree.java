package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;

        // bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        List<String> rootLevel = new ArrayList<>();
        rootLevel.add(String.valueOf(root.val));
        res.add(rootLevel);

        while (!q.isEmpty()) {
            int size = q.size();
            List<String> nextLevel = new ArrayList<>();
            boolean nextLevelEmpty = true;
            int nNodes = 0;
            int max = (int) Math.pow(2, depth);

            for (int i = 0; i < size; i++) {
                root = q.poll();

                if (root != null) {
                    nextLevel.add(root.left == null ? "" : String.valueOf(root.left.val));
                    q.offer(root.left);

                    nextLevel.add("");

                    nextLevel.add(root.right == null ? "" : String.valueOf(root.right.val));
                    q.offer(root.right);
                    if (root.left != null || root.right != null)
                        nextLevelEmpty = false;
                }
                nNodes += 2;
                if (nNodes < max) nextLevel.add("");
            }

            if (!nextLevelEmpty) res.add(nextLevel);

            depth++;
        }

        // traverse bottom-up
        //for ()

        return res;
    }
}
