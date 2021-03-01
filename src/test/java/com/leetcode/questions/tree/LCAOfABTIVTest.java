package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LCAOfABTIVTest {
    private LCAOfABTIV lcaOfABTIV;

    @Before
    public void setUp() {
        lcaOfABTIV = new LCAOfABTIV();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        assertThat(lcaOfABTIV.lowestCommonAncestor(root, new TreeNode[]{root.left.right.right, root.left.right.left})).isEqualTo(root.left.right);
    }
}