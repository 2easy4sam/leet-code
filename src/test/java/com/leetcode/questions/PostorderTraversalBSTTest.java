package com.leetcode.questions;

import com.leetcode.questions.PostorderTraversalBST;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PostorderTraversalBSTTest {
    private PostorderTraversalBST postorderTraversalBST;

    @Before
    public void setUp() {
        postorderTraversalBST = new PostorderTraversalBST();
    }

    @Test
    public void test() {
        PostorderTraversalBST.TreeNode F = new PostorderTraversalBST.TreeNode(6);

        F.left = new PostorderTraversalBST.TreeNode(2);
        F.right = new PostorderTraversalBST.TreeNode(7);

        F.left.left = new PostorderTraversalBST.TreeNode(1);
        F.left.right = new PostorderTraversalBST.TreeNode(4);

        F.left.right.left = new PostorderTraversalBST.TreeNode(3);
        F.left.right.right = new PostorderTraversalBST.TreeNode(5);

        F.right.right = new PostorderTraversalBST.TreeNode(9);

        F.right.right.left = new PostorderTraversalBST.TreeNode(8);

        List<Integer> results = postorderTraversalBST.solve(F);
        System.out.println(results.toString());
    }
}