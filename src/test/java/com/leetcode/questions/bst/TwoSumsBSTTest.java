package com.leetcode.questions.bst;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumsBSTTest {
    private TwoSumsBST twoSumsBST;

    @Before
    public void setup() {
        twoSumsBST = new TwoSumsBST();
    }

    @Test
    public void test_1() {
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(4);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(0);
        tree2.right = new TreeNode(3);

        int target = 5;

        assertThat(twoSumsBST.twoSumBSTs(tree1, tree2, target)).isTrue();
    }
}