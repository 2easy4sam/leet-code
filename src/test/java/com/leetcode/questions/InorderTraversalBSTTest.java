package com.leetcode.questions;

import com.leetcode.questions.InorderTraversalBST;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InorderTraversalBSTTest {
    private InorderTraversalBST inorderTraversalBST;

    @Before
    public void setUp() {
        inorderTraversalBST = new InorderTraversalBST();
    }

    @Test
    public void test() {
        InorderTraversalBST.TreeNode root = new InorderTraversalBST.TreeNode(1);
        root.right = new InorderTraversalBST.TreeNode(2);
        root.right.left = new InorderTraversalBST.TreeNode(3);

        List<Integer> results = inorderTraversalBST.solve(root);
        assertThat(results).containsExactly(1, 3, 2);
    }

    @Test
    public void test_1() {
        InorderTraversalBST.TreeNode F = new InorderTraversalBST.TreeNode(6);
        F.left = new InorderTraversalBST.TreeNode(2);
        F.right = new InorderTraversalBST.TreeNode(7);

        F.left.left = new InorderTraversalBST.TreeNode(1);
        F.left.right = new InorderTraversalBST.TreeNode(4);

        F.left.right.left = new InorderTraversalBST.TreeNode(3);
        F.left.right.right = new InorderTraversalBST.TreeNode(5);

        F.right.right = new InorderTraversalBST.TreeNode(9);

        F.right.right.left = new InorderTraversalBST.TreeNode(8);

        List<Integer> results = inorderTraversalBST.solve(F);
        System.out.println(results.toString());
    }
}