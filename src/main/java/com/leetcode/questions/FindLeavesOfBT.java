package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindLeavesOfBT {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> ans = new ArrayList<>();

        // a leaf is a node that has no children

        while (root.left != null || root.right != null) {
            List<Integer> list = new ArrayList<>();

            root.left = helper(root.left, list);
            root.right = helper(root.right, list);

            ans.add(list);
        }

        ans.add(Collections.singletonList(root.val));

        return ans;
    }

    private TreeNode helper(TreeNode node, List<Integer> list) {
        if (node == null) return null;

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = helper(node.left, list);
        node.right = helper(node.right, list);

        if (left == null && right == null) {
            list.add(node.val);
            return null;
        }

        return node;
    }
}
