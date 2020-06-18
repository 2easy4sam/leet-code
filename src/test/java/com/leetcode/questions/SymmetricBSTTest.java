package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SymmetricBSTTest {
    private SymmetricBST symmetricBST;

    @Before
    public void setUp() {
        symmetricBST = new SymmetricBST();
    }

    @Test
    public void test_symmetric() {
        SymmetricBST.TreeNode root = new SymmetricBST.TreeNode(1);
        root.left = new SymmetricBST.TreeNode(2);
        root.right = new SymmetricBST.TreeNode(2);

        root.left.left = new SymmetricBST.TreeNode(3);
        root.left.right = new SymmetricBST.TreeNode(4);

        root.right.left = new SymmetricBST.TreeNode(4);
        root.right.right = new SymmetricBST.TreeNode(3);

        boolean res = symmetricBST.solve(root);

        assertThat(res).isTrue();
    }

    @Test
    public void test_non_symmetric() {
        SymmetricBST.TreeNode root = new SymmetricBST.TreeNode(1);
        root.left = new SymmetricBST.TreeNode(2);
        root.right = new SymmetricBST.TreeNode(2);

        root.left.left = null;
        root.left.right = new SymmetricBST.TreeNode(3);

        root.right.left = null;
        root.right.right = new SymmetricBST.TreeNode(3);

        boolean res = symmetricBST.solve(root);

        assertThat(res).isFalse();
    }
}