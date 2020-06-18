package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeepestLeaveSumsTest {
    private DeepestLeaveSums deepestLeaveSums;

    @Before
    public void setUp() {
        deepestLeaveSums = new DeepestLeaveSums();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertThat(deepestLeaveSums.deepestLeavesSum(root)).isEqualTo(5);
    }

    @Test
    public void test_2() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        assertThat(deepestLeaveSums.deepestLeavesSum(root)).isEqualTo(15);
    }
}