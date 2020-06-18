package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBT {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.peek() != null) {
            root = q.poll();
            q.offer(root.left);
            q.offer(root.right);
        }

        while (!q.isEmpty() && q.peek() == null) {
            q.poll();
        }

        return q.isEmpty();
    }
}
