package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.Arrays;

public class ConstructBTFromInAndPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // postorder: print when all sub-tree nodes have been visited
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;

        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);

        // find index of val in inorder
        int i = 0;
        while (inorder[i] != val && i < inorder.length - 1) i++;
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
        int[] rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);

        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, leftInorder.length + rightInorder.length);

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
