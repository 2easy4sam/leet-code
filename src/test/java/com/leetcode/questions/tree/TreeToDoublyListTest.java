package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;
import com.leetcode.questions.SerializeAndDeserializeBT;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeToDoublyListTest {
    private TreeToDoublyList treeToDoublyList;
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setup() {
        treeToDoublyList = new TreeToDoublyList();
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode head = treeToDoublyList.treeToDoublyList(root);

        assertThat(head.val).isEqualTo(1);
        assertThat(head.right.val).isEqualTo(2);
        assertThat(head.right.right.val).isEqualTo(3);
        assertThat(head.right.right.right.val).isEqualTo(4);
        assertThat(head.right.right.right.right.val).isEqualTo(5);
        assertThat(head.right.right.right.right.right.val).isEqualTo(1);
        assertThat(head.left.val).isEqualTo(5);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode head = treeToDoublyList.treeToDoublyList(root);

        assertThat(head.val).isEqualTo(3);
        assertThat(head.right.val).isEqualTo(4);
        assertThat(head.right.right.val).isEqualTo(5);
        assertThat(head.left.val).isEqualTo(5);
    }

    @Test
    public void test_3() {
        String data = "[28,-98,67,null,-89,62]";
        TreeNode root = serializeAndDeserializeBT.deserialize(data);

        TreeNode head = treeToDoublyList.treeToDoublyList(root);

        assertThat(head.val).isEqualTo(-98);
        assertThat(head.left.val).isEqualTo(62);
    }
}