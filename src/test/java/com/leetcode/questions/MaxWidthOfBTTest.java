package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxWidthOfBTTest {
    private MaxWidthOfBT maxWidthOfBT;

    @Before
    public void setUp() {
        maxWidthOfBT = new MaxWidthOfBT();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        assertThat(maxWidthOfBT.widthOfBinaryTree(root)).isEqualTo(4);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        assertThat(maxWidthOfBT.widthOfBinaryTree(root)).isEqualTo(2);
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);

        assertThat(maxWidthOfBT.widthOfBinaryTree(root)).isEqualTo(2);
    }

    @Test
    public void test_4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        assertThat(maxWidthOfBT.widthOfBinaryTree(root)).isEqualTo(8);
    }

    @Test
    public void test_5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        assertThat(maxWidthOfBT.widthOfBinaryTree(root)).isEqualTo(6);
    }

    @Test
    public void test_6() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        assertThat(maxWidthOfBT.widthOfBinaryTree(root)).isEqualTo(7);
    }

    @Test
    public void test_7() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        assertThat(maxWidthOfBT.widthOfBinaryTree(root)).isEqualTo(8);
    }
}