package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBTFromInAndPostOrderTest {
    private ConstructBTFromInAndPostOrder constructBTFromInAndPostOrder;

    @Before
    public void setUp() {
        constructBTFromInAndPostOrder = new ConstructBTFromInAndPostOrder();
    }

    @Test
    public void test_1() {
        int[] inorder = new int[]{1, 3, 2};
        int[] postorder = new int[]{1, 2, 3};

        TreeNode root = constructBTFromInAndPostOrder.buildTree(inorder, postorder);

        assertThat(root.val).isEqualTo(3);
        assertThat(root.left.val).isEqualTo(1);
        assertThat(root.right.val).isEqualTo(2);
    }
}