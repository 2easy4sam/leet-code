package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxDiffBetweenNodeAndAncestorTest {
    private MaxDiffBetweenNodeAndAncestor maxDiffBetweenNodeAndAncestor;

    @Before
    public void setUp() {
        maxDiffBetweenNodeAndAncestor = new MaxDiffBetweenNodeAndAncestor();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(14);
        root.right.right.right.left = new TreeNode(13);

        assertThat(maxDiffBetweenNodeAndAncestor.maxAncestorDiff(root)).isEqualTo(7);
    }
}