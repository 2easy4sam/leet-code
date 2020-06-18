package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A complete binary tree is a binary tree in which every level,
 * except possibly the last, is completely filled, and all nodes
 * are as far left as possible.
 *
 * Write a data structure CBTInserter that is initialized with a
 * complete binary tree and supports the following operations:
 *
 *  - CBTInserter(TreeNode root) initializes the data structure on
 *  a given tree with head node root;
 *  - CBTInserter.insert(int v) will insert a TreeNode into the tree
 *  with value node.val = v so that the tree remains complete, and
 *  returns the value of the parent of the inserted TreeNode;
 *  - CBTInserter.get_root() will return the head node of the tree.
 */
public class CBTInserter {

    private List<TreeNode> nodes;

    public CBTInserter(TreeNode root) {
        nodes = new ArrayList<>();
        nodes.add(root);

        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null)
                nodes.add(nodes.get(i).left);
            if (nodes.get(i).right != null)
                nodes.add(nodes.get(i).right);
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        int size = nodes.size();

        // recap: the index of left child of the ith node is
        //      i * 2
        // the index of its right child is i * 2 + 1
        // given that the list/array is 1-indexed
        TreeNode parent = nodes.get((size - 1) / 2);
        nodes.add(node);

        if (size % 2 == 1) {
            // should be the left node of its parent
            parent.left = node;
        } else {
            // right node of its parent
            parent.right = node;
        }

        return parent.val;
    }

    public TreeNode get_root() {
        return nodes.get(0);
    }
}
