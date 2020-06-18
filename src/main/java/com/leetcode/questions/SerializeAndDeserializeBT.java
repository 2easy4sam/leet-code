package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> serialized = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean isNextLevelEmpty = false;

        while (!q.isEmpty() && !isNextLevelEmpty) {
            final int size = q.size();
            isNextLevelEmpty = true;

            for (int i = 0; i < size; i++) {
                root = q.remove();

                if (root != null) {
                    serialized.add(root.val);
                    if (root.left != null || root.right != null) isNextLevelEmpty = false;
                    // no need for null check, so that we'd always
                    // have the expected number of nodes at each level
                    q.add(root.left);
                    q.add(root.right);
                } else {
                    serialized.add(null);
                }
            }
        }

        return serialized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // first off, strip out square brackets and spaces
        // then split it into an array/list

        List<Integer> list = Arrays.stream(data.replaceAll("[^-0-9,\\w]+", "").split(","))
                .map(num -> {
                    if (num.equals("null")) {
                        return null;
                    }

                    return new Integer(num);
                })
                .collect(Collectors.toList());

        TreeNode root = null;

        int n = list.size();
        Queue<TreeNode> q = new LinkedList<>();

        for (int nNodes = 1; nNodes <= n; nNodes *= 2) {
            int i = nNodes - 1, j = i + nNodes;

            TreeNode prev = null;

            while (i < j && i < n) {
                boolean isLeft = i % 2 != 0;

                if (!q.isEmpty() && isLeft) {
                    prev = q.remove();
                }

                Integer val = list.get(i);

                if (val != null) {
                    if (prev != null) {
                        TreeNode node = new TreeNode(val);

                        if (isLeft) prev.left = node;
                        else prev.right = node;

                        q.add(node);
                    } else if (root == null) {
                        root = new TreeNode(val);
                        q.add(root);
                    }
                }

                i++;
            }
        }

        return root;
    }
}
