package com.leetcode.questions;

import java.util.LinkedList;

/**
 * Given a binary tree, check whether it is a mirror
 * of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3]
 * But the following [1,2,2,null,3,null,3] is not
 */
public class SymmetricBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean solve(TreeNode root) {
        if (root == null) return false;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            if (list.size() % 2 != 0 && list.size() != 1) return false;

            int iter = list.size() / 2;

            LinkedList<TreeNode> tempList = new LinkedList<>(list);

            if (iter != 0) {
                for (int i = 0; i < iter; i++) {
                    TreeNode head = list.pollFirst();
                    TreeNode tail = list.pollLast();

                    if (head == null && tail == null) continue;
                    if (head == null || tail == null
                            || head.val != tail.val) return false;
                }
            } else {
                list.pop();
            }

            while (!tempList.isEmpty()) {
                TreeNode node = tempList.poll();

                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            }
        }

        return true;
    }
}
