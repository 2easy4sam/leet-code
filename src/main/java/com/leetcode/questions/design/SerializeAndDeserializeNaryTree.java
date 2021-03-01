package com.leetcode.questions.design;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeNaryTree {
    // Definition for a Node.
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    // Encodes a tree to a single string.
    /*
    encode the tree in such a way that:
        - 1(3(5 6) 2 4)
    */
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        List<Node> children = root.children;

        if (children != null) {
            sb.append("(");
            String separator = "";

            for (Node c : children) {
                sb.append(separator).append(serialize(c));
                separator = " ";
            }

            sb.append(")");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        int i = 0;
        while (isInt(data.charAt(i))) {
            i++;
        }

        Node root = new Node(Integer.parseInt(data.substring(0, i)));
        root.children = new ArrayList<>();

        dfs(data.substring(i + 1, data.length() - 1), root);

        return root;
    }

    private void dfs(String data, Node parent) {
        if (data == null || data.isEmpty()) return;

        int i = 0;
        Node prev = null;

        while (i < data.length()) {
            if (isInt(data.charAt(i))) {
                int begin = i;

                while (i < data.length() && isInt(data.charAt(i))) {
                    i++;
                }

                // now i is pointing at a non-digit
                Node node = new Node(Integer.parseInt(data.substring(begin, i)));
                node.children = new ArrayList<>();
                parent.children.add(node);
                prev = node;
            } else if (data.charAt(i) == '(') {
                // find the matching )
                int cnt = 1;
                int begin = ++i, end = -1;

                while (i < data.length() && cnt != 0) {
                    if (data.charAt(i) == '(') cnt++;
                    else if (data.charAt(i) == ')') cnt--;
                    if (cnt == 0) end = i;
                    i++;
                }

                // i is now past the matching )
                dfs(data.substring(begin, end), prev);
            } else {
                i++;
            }
        }
    }

    private boolean isInt(char c) {
        int res = c - '0';
        return res >= 0 && res <= 9;
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}