package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A full binary tree is a binary tree where each node has exactly
 * 0 or 2 children.
 * <p>
 * Return a list of all possible full binary trees with N nodes.
 * Each element of the answer is the root node of one possible tree.
 * <p>
 * Each node of each tree in the answer must have node.val = 0.
 * <p>
 * You may return the final list of trees in any order.
 */
public class AllPossibleFullBT {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        // given the restrictions, we know that even numbers should
        // always return empty list
        if (N % 2 == 0) return list;
        // when n is 1, a node with 0 children should be created
        else if (N == 1) {
            TreeNode node = new TreeNode(0);
            list.add(node);
            return list;
        }

        for (int i = 1; i <= N - 1; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(0);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
