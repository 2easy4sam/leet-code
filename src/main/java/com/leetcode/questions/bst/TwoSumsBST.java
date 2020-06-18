package com.leetcode.questions.bst;

import com.leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TwoSumsBST {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;
        // the nodes have to be 1 from each tree, in other words, they can't
        // be from the same tree

        // given the fact that it is a BST, meaning nodes with smaller values on
        // the left, and nodes with greater values on the right
        // the search time is therefore O(log n)
        // what we can do then is:
        // 1. traverse root1, at each node, calculate the difference d
        // 2. find d in root2
        // 2.1. if found, return true, exit
        // 2.2. if not found, continue traversing root1
        // 3. exit and return false when every node of root1 has been visited

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root1);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                root1 = q.poll();

                if (root1 != null) {
                    if (findNumber(root2, target - root1.val))
                        return true;

                    q.offer(root1.left);
                    q.offer(root1.right);
                }
            }
        }

        return false;
    }

    private boolean findNumber(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return root.val < target
                ? findNumber(root.right, target)
                : findNumber(root.left, target);
    }
}
