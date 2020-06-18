package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateBSTTest {
    private ValidateBST validateBST;

    @Before
    public void setUp() {
        validateBST = new ValidateBST();
    }

    @Test
    @Ignore
    public void test_1() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.right = new TreeNode(20);

        assertThat(validateBST.isValidBST(root)).isTrue();
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(12);

        root.right.right = new TreeNode(20);

        assertThat(validateBST.validateBSTResursive(root)).isFalse();
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);

        assertThat(validateBST.validateBSTResursive(root)).isFalse();
    }
}