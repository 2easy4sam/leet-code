package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlattenBTToLinkedListTest {
    private FlattenBTToLinkedList flattenBinaryTreeToLinkedList;

    @Before
    public void setUp() {
        flattenBinaryTreeToLinkedList = new FlattenBTToLinkedList();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flattenBinaryTreeToLinkedList.flatten(root);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.right.right.val).isEqualTo(3);
        assertThat(root.right.right.right.val).isEqualTo(4);
        assertThat(root.right.right.right.right.val).isEqualTo(5);
        assertThat(root.right.right.right.right.right.val).isEqualTo(6);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        flattenBinaryTreeToLinkedList.flatten(root);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.right.right.val).isEqualTo(3);
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        flattenBinaryTreeToLinkedList.flatten(root);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.left).isNull();
        assertThat(root.right.val).isEqualTo(2);
        assertThat(root.right.left).isNull();
        assertThat(root.right.right.val).isEqualTo(3);
        assertThat(root.right.right.left).isNull();
    }
}