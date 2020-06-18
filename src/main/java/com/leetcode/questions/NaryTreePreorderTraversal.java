package com.leetcode.questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreePreorderTraversal {
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

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.poll();

            if (current != null) {
                result.add(current.val);

                for (int i = current.children.size() - 1; i > -1; i--) {
                    stack.push(current.children.get(i));
                }
            }
        }

        return result;
    }
}
