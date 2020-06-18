package com.leetcode.questions.tree;

/**
 * Given a node in a binary search tree, find the in-order successor
 * of that node in the BST.
 * <p>
 * If that node has no in-order successor, return null.
 * <p>
 * The successor of a node is the node with the smallest key greater
 * than node.val.
 * <p>
 * You will have direct access to the node but not to the root of the
 * tree. Each node will have a reference to its parent node.
 */
public class InorderSuccessorOfBSTII {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        // the smallest in-order successor is always the bottom-left
        // leaf of the immediate right node of a given node
        // IF such node doesn't exist, THEN it's its parent
        // IF it has no parent, i.e. it's a root node, THEN return null
        // IF it has no right node AND it has a parent, THEN return null

        Node right = node.right;
        Node parent = node.parent;

        if (parent == null && right == null) return null;
        if (parent != null && right == null && parent.val < node.val) {
            while (parent.parent != null && parent.val < node.val)
                parent = parent.parent;
            if (parent.val < node.val) return null;
            return parent;
        }
        if (right != null) {
            while (right.left != null) right = right.left;
        } else if (parent.val > node.val) return parent;
        return right;
    }

    public Node inorderSuccessor2(Node node) {

        Node right = node.right;
        Node parent = node.parent;

        if (parent != null) {
            if (right == null) {
                if (parent.left == node) return parent;
                else {
                    // right child
                    while (node.parent != null && node.parent.right == node) {
                        node = node.parent;
                    }

                    return node.parent;
                }
            }
        }
        if (right != null) while (right.left != null) right = right.left;

        return right;
    }
}
