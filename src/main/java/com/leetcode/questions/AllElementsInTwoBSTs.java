package com.leetcode.questions;

import com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBSTs {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> numbers = new ArrayList<>();
        // brute force
        dfs(root1, numbers);
        dfs(root2, numbers);

        Collections.sort(numbers);

        return numbers;
    }

    private void dfs(TreeNode root, List<Integer> numbers) {
        // in-order traversal
        if (root != null) {
            dfs(root.left, numbers);
            numbers.add(root.val);
            dfs(root.right, numbers);
        }
    }

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        dfs(root1, l1);
        dfs(root2, l2);

        int i = 0, j = 0;

        while (i < l1.size() || j < l2.size()) {
            if (j == l2.size() || i < l1.size() && l1.get(i) < l2.get(j)) {
                ans.add(l1.get(i));
                i++;
            } else {
                ans.add(l2.get(j));
                j++;
            }
        }

        return ans;
    }
}
