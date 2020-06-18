package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class PathSumBST {
    public boolean hasPathSum(TreeNode root, int sum) {

        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> sums = new LinkedList<>();

        nodes.push(root);
        sums.push(sum);

        TreeNode current = root;

        while (!nodes.isEmpty() && current != null) {

            TreeNode node = nodes.poll();
            Integer val = sums.poll();

            if (node.left == null && node.right == null && val == node.val) return true;

            if (node.right != null) {
                nodes.push(node.right);
                sums.push(val - node.val);
            }

            if (node.left != null) {
                nodes.push(node.left);
                sums.push(val - node.val);
            }
        }

        return false;
    }
}
