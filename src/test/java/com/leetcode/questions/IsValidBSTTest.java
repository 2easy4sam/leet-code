package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsValidBSTTest {
    private IsValidBST isValidBST;

    @Before
    public void setUp() {
        isValidBST = new IsValidBST();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean actual = isValidBST.isValidBST(root);

        assertThat(actual).isTrue();
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        boolean actual = isValidBST.isValidBST(root);

        assertThat(actual).isFalse();
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(20);

        boolean actual = isValidBST.isValidBST(root);

        assertThat(actual).isTrue();
    }
}