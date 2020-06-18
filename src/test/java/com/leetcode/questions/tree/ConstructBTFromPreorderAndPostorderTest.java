package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBTFromPreorderAndPostorderTest {
    private ConstructBTFromPreorderAndPostorder constructBTFromPreorderAndPostorder;

    @Before
    public void setup() {
        constructBTFromPreorderAndPostorder = new ConstructBTFromPreorderAndPostorder();
    }

    @Test
    public void test_1() {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};

        TreeNode root = constructBTFromPreorderAndPostorder.constructFromPrePostR(pre, post);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.right.val).isEqualTo(3);
        assertThat(root.left.left.val).isEqualTo(4);
        assertThat(root.left.right.val).isEqualTo(5);
        assertThat(root.right.left.val).isEqualTo(6);
        assertThat(root.right.right.val).isEqualTo(7);
    }

    @Test
    public void test_2() {
        int[] pre = new int[]{2, 1, 3};
        int[] post = new int[]{3, 1, 2};

        TreeNode root = constructBTFromPreorderAndPostorder.constructFromPrePostR(pre, post);

        assertThat(root.val).isEqualTo(2);
        assertThat(root.left.val).isEqualTo(1);
        assertThat(root.left.left.val).isEqualTo(3);
    }

    @Test
    public void test_3() {
        int[] pre = new int[]{2, 1, 3, 4};
        int[] post = new int[]{4, 3, 1, 2};

        TreeNode root = constructBTFromPreorderAndPostorder.constructFromPrePostR(pre, post);

        assertThat(root.val).isEqualTo(2);
        assertThat(root.left.val).isEqualTo(1);
        assertThat(root.left.left.val).isEqualTo(3);
        assertThat(root.left.left.left.val).isEqualTo(4);
    }
}