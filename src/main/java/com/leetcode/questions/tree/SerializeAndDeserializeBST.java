package com.leetcode.questions.tree;

import com.leetcode.datastructures.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.substring(0, sb.length() - 1);
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        if (q.isEmpty()) return null;
        TreeNode root = createNode(q.poll());
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }

    private TreeNode createNode(String data) {
        return data.equals("#") ? null : new TreeNode(Integer.parseInt(data));
    }
}
