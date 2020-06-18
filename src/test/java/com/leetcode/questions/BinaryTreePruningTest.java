package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreePruningTest {
    private BinaryTreePruning binaryTreePruning;

    @Before
    public void setUp() {
        binaryTreePruning = new BinaryTreePruning();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        TreeNode actual = binaryTreePruning.pruneTree(root);

        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.right.val).isEqualTo(0);
        assertThat(actual.right.right.val).isEqualTo(1);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        TreeNode actual = binaryTreePruning.pruneTree(root);

        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.left).isNull();
        assertThat(actual.right.val).isEqualTo(1);
        assertThat(actual.right.left).isNull();
        assertThat(actual.right.right.val).isEqualTo(1);
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(0);

        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        TreeNode actual = binaryTreePruning.pruneTree(root);

        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.left.val).isEqualTo(1);
        assertThat(actual.left.left.val).isEqualTo(1);
        assertThat(actual.left.left.left).isNull();
        assertThat(actual.left.right.val).isEqualTo(1);
        assertThat(actual.right.val).isEqualTo(0);
        assertThat(actual.right.left).isNull();
        assertThat(actual.right.right.val).isEqualTo(1);
    }

    @Test
    public void test_4() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        TreeNode actual = binaryTreePruning.pruneTree(root);

        assertThat(actual).isNull();
    }

    @Test
    public void test_5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        TreeNode actual = binaryTreePruning.pruneTree(root);

        assertThat(actual.val).isEqualTo(1);
        assertThat(actual.left.val).isEqualTo(1);
        assertThat(actual.right.val).isEqualTo(1);
    }
}