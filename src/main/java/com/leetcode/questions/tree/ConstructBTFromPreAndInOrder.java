package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.Arrays;

public class ConstructBTFromPreAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        int val = preorder[0];
        TreeNode root = new TreeNode(val);

        // find the index of val in inorder
        int i = 0;
        while (inorder[i] != val && i < inorder.length - 1) i++;

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
        int[] rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
