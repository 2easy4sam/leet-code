package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MaxDepthBSTTest {
    private MaxDepthBST maxDepthBST;

    @Before
    public void setUp() {
        maxDepthBST = new MaxDepthBST();
    }

    @Test
    public void test_iterative() {
        MaxDepthBST.TreeNode F = new MaxDepthBST.TreeNode(6);

        F.left = new MaxDepthBST.TreeNode(2);
        F.right = new MaxDepthBST.TreeNode(7);

        F.left.left = new MaxDepthBST.TreeNode(1);
        F.left.right = new MaxDepthBST.TreeNode(4);

        F.left.right.left = new MaxDepthBST.TreeNode(3);
        F.left.right.right = new MaxDepthBST.TreeNode(5);

        F.right.right = new MaxDepthBST.TreeNode(9);

        F.right.right.left = new MaxDepthBST.TreeNode(8);
        
        int depth = maxDepthBST.iterative(F);

        assertThat(depth).isEqualTo(4);
    }

    @Test
    public void test_recursive() {
        MaxDepthBST.TreeNode F = new MaxDepthBST.TreeNode(6);

        F.left = new MaxDepthBST.TreeNode(2);
        F.right = new MaxDepthBST.TreeNode(7);

        F.left.left = new MaxDepthBST.TreeNode(1);
        F.left.right = new MaxDepthBST.TreeNode(4);

        F.left.right.left = new MaxDepthBST.TreeNode(3);
        F.left.right.right = new MaxDepthBST.TreeNode(5);

        F.right.right = new MaxDepthBST.TreeNode(9);

        F.right.right.left = new MaxDepthBST.TreeNode(8);

        int depth = maxDepthBST.recursive(F);

        assertThat(depth).isEqualTo(4);
    }

}