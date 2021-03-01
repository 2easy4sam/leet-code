package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CorrectABinaryTreeTest {
    private CorrectABinaryTree correctABinaryTree;

    @Before
    public void setUp() {
        correctABinaryTree = new CorrectABinaryTree();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = root.right;

        TreeNode actual = correctABinaryTree.correctBinaryTree(root);

        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.right.val).isEqualTo(3);
        assertThat(actual.left).isNull();
    }
}