package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindCorrespondingNodeInBT {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null) return null;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(original);
        q2.offer(cloned);

        while (!q1.isEmpty()) {
            int size = q1.size();

            for (int i = 0; i < size; i++) {
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();
                if (node1.val == target.val) return node2;

                if (node1.left != null) {
                    q1.offer(node1.left);
                    q2.offer(node2.left);
                }

                if (node1.right == null) {
                    q1.offer(node1.right);
                    q2.offer(node2.right);
                }
            }
        }

        return null;
    }
}
