package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

/**
 * Return any binary tree that matches the given preorder and
 * postorder traversals.
 * <p>
 * Values in the traversals pre and post are distinct positive
 * integers.
 */
public class ConstructBTFromPreorderAndPostorder {
    private int preIndex = 0, posIndex = 0;

    public TreeNode constructFromPrePostR(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePostR(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePostR(pre, post);
        posIndex++;
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, 0, pre.length - 1, post, 0, post.length);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd)
            return new TreeNode(pre[preStart]);

        TreeNode root = new TreeNode(pre[preStart]);

        int leftPreStart = preStart + 1;
        int leftPostEnd = findLeftPostEnd(post, pre[leftPreStart], postStart, postEnd);
        int leftPreEnd = leftPreStart + (leftPostEnd - postStart);

        TreeNode left = helper(pre, leftPreStart, leftPreEnd, post, postStart, leftPostEnd);
        TreeNode right = helper(pre, leftPreEnd + 1, preEnd, post, leftPostEnd + 1, postEnd - 1);

        root.left = left;
        root.right = right;

        return root;
    }

    private int findLeftPostEnd(int[] post, int target, int postStart, int postEnd) {
        for (int i = postStart; i < postEnd; i++) {
            if (post[i] == target) return i;
        }

        return -1;
    }
}
