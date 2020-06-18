package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxAvgSubtreeTest {
    private MaxAvgSubtree maxAvgSubtree;

    @Before
    public void setUp() {
        maxAvgSubtree = new MaxAvgSubtree();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);

        assertThat(maxAvgSubtree.maximumAverageSubtree(root)).isEqualTo(6.0);
    }
}