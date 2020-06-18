package com.leetcode.questions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.poll();

            if (root != null) {
                result.addFirst(root.val);

                for (Node child : root.children) {
                    stack.push(child);
                }
            }
        }

        return result;
    }
}
