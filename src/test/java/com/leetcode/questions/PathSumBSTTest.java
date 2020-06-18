package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathSumBSTTest {

    private PathSumBST pathSumBST;

    @Before
    public void setUp() {
        pathSumBST = new PathSumBST();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.right = null;

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.left = null;
        root.right.right.right = new TreeNode(1);

        boolean res = pathSumBST.hasPathSum(root, 22);
        assertThat(res).isTrue();
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(-2);

        root.left = null;
        root.right = new TreeNode(-3);

        boolean res = pathSumBST.hasPathSum(root, -2);
        assertThat(res).isFalse();
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(-2);

        root.left = null;
        root.right = new TreeNode(-3);

        boolean res = pathSumBST.hasPathSum(root, -5);
        assertThat(res).isTrue();
    }

    @Test
    public void test_4() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(-2);
        root.right.right = null;

        root.left.left.left = new TreeNode(-1);

        boolean res = pathSumBST.hasPathSum(root, -4);
        assertThat(res).isTrue();
    }
}