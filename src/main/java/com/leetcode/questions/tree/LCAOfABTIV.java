package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.LinkedList;

public class LCAOfABTIV {
    /*
    - intuition:
        - for a node to be the lca of two other nodes, it must have one node in the left branch and the other
        in the right branch. IF both are found in the same branch of x, then x is not the lca

        e.g. in the example 1, let's say we want to find the lca of 4 and 7, while 3 is an ancestor, but both
        4 and 7 are in its left branch, therefore 3 cannot be the lca and the right answer is 2

        -
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        LinkedList<TreeNode> ll = new LinkedList<>();
        for (TreeNode node : nodes) ll.offer(node);

        while (ll.size() > 1) {
            TreeNode lca = findLca(root, ll.removeFirst(), ll.removeFirst());
            ll.offerFirst(lca);
        }

        return ll.removeFirst();
    }

    private TreeNode findLca(TreeNode curr, TreeNode n1, TreeNode n2) {
        if (curr == null) return null;

        if (curr == n1) {
            if (find(curr.left, n2) || find(curr.right, n2)) return n1;
        } else if (curr == n2) {
            if (find(curr.left, n1) || find(curr.right, n1)) return n2;
        } else {
            if ((find(curr.left, n1) && find(curr.right, n2)) || (find(curr.left, n2) && find(curr.right, n1)))
                return curr;
        }

        return null;
    }

    private boolean find(TreeNode node, TreeNode target) {
        if (node == null) return false;
        if (node == target) return true;

        return find(node.left, target) || find(node.right, target);
    }
}
