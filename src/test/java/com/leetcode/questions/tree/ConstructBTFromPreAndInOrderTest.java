package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBTFromPreAndInOrderTest {
    private ConstructBTFromPreAndInOrder constructBTFromPreAndInOrder;

    @Before
    public void setUp() {
        constructBTFromPreAndInOrder = new ConstructBTFromPreAndInOrder();
    }

    @Test
    public void test_1() {
        int[] preorder = new int[]{3, 1, 2};
        int[] inorder = new int[]{1, 3, 2};

        TreeNode root = constructBTFromPreAndInOrder.buildTree(preorder, inorder);

        assertThat(root.val).isEqualTo(3);
        assertThat(root.left.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(2);
    }
}