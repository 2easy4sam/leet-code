package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeUpsideDownTest {
    private BinaryTreeUpsideDown binaryTreeUpsideDown;

    @Before
    public void setUp() {
        binaryTreeUpsideDown = new BinaryTreeUpsideDown();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        binaryTreeUpsideDown.upsideDownBinaryTree(root);
    }
}