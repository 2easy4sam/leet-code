package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class ConvertBSTToGreaterTreeTest {
    private ConvertBSTToGreaterTree convertBSTToGreaterTree;

    @Before
    public void setUp() {
        convertBSTToGreaterTree = new ConvertBSTToGreaterTree();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(11);

        convertBSTToGreaterTree.convertBST(root);
    }
}