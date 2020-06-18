package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.tree.BTMaximumPathSum;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BTMaximumPathSumTest {
    private BTMaximumPathSum BTMaximumPathSum;

    @Before
    public void setUp() {
        BTMaximumPathSum = new BTMaximumPathSum();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertThat(BTMaximumPathSum.maxPathSum(root)).isEqualTo(6);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertThat(BTMaximumPathSum.maxPathSum(root)).isEqualTo(42);
    }
}