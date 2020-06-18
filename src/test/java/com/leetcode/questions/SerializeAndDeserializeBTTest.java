package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializeAndDeserializeBTTest {
    private SerializeAndDeserializeBT serializeAndDeserializeBT;

    @Before
    public void setUp() {
        serializeAndDeserializeBT = new SerializeAndDeserializeBT();
    }

    @Test
    public void serialize_1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serializeAndDeserializeBT.serialize(root);

        assertThat(serialized).isEqualTo("[1, 2, 3, null, null, 4, 5]");
    }

    @Test
    public void serialize_2() {
        String serialized = serializeAndDeserializeBT.serialize(null);

        assertThat(serialized).isEqualTo("[null]");
    }

    @Test
    public void serialize_3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        String serialized = serializeAndDeserializeBT.serialize(root);

        assertThat(serialized).isEqualTo("[1, 2, 3, 4, 5, null, null]");
    }

    @Test
    public void serialize_4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        String serialized = serializeAndDeserializeBT.serialize(root);

        assertThat(serialized).isEqualTo("[1, 2, 3]");
    }

    @Test
    public void serialize_5() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);

        String serialized = serializeAndDeserializeBT.serialize(root);

        assertThat(serialized).isEqualTo("[1, 2, 3, null, 4, 5, null]");
    }

    @Test
    public void deserialize_1() {
        String data = "[1, 2, 3]";

        TreeNode root = serializeAndDeserializeBT.deserialize(data);

        assertThat(root.val).isEqualTo(1);
        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.right.val).isEqualTo(3);
    }

    @Test
    public void deserialize_2() {
        String data = "[1, 2, 3, null, 4, 5, null]";

        TreeNode root = serializeAndDeserializeBT.deserialize(data);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(3);
        expected.left.right = new TreeNode(4);
        expected.right.left = new TreeNode(5);

        assertThat(root).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void deserialize_3() {
        String data = "[-1,0,1]";

        TreeNode actual = serializeAndDeserializeBT.deserialize(data);

        TreeNode expected = new TreeNode(-1);
        expected.left = new TreeNode(0);
        expected.right = new TreeNode(1);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void deserialize_4() {
        String data = "[1,3,null,null,4]";

        TreeNode actual = serializeAndDeserializeBT.deserialize(data);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(3);
        expected.left.right = new TreeNode(4);

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void deserialize_5() {
        String data = "[28,-98,67,null,-89,62,null,-97,-25,null,64,null,null,-72,-9,null,null,-88,-41,null,-7,null,-78,-53,null,null,2,-85,-77,-69,-42,-1]";

        TreeNode root = serializeAndDeserializeBT.deserialize(data);

        assertThat(root.val).isEqualTo(28);
        assertThat(root.left.val).isEqualTo(-98);
        assertThat(root.right.val).isEqualTo(67);
    }
}