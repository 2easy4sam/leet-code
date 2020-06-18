package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LCAOfDeepestLeavesTest {
    private LCAOfDeepestLeaves lcaOfDeepestLeaves;

    @Before
    public void setUp() {
        lcaOfDeepestLeaves = new LCAOfDeepestLeaves();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode lca = lcaOfDeepestLeaves.lcaDeepestLeaves(root);

        assertThat(lca.val).isEqualTo(2);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        TreeNode lca = lcaOfDeepestLeaves.lcaDeepestLeaves(root);

        assertThat(lca.val).isEqualTo(4);
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode lca = lcaOfDeepestLeaves.lcaDeepestLeaves(root);

        assertThat(lca.val).isEqualTo(1);
    }

    @Test
    public void test_4() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);

        TreeNode lca = lcaOfDeepestLeaves.lcaDeepestLeaves(root);

        assertThat(lca.val).isEqualTo(5);
    }

    @Test
    public void test_5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);

        TreeNode lca = lcaOfDeepestLeaves.lcaDeepestLeaves(root);

        assertThat(lca.val).isEqualTo(5);
    }
}