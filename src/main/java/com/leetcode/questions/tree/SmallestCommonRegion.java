package com.leetcode.questions.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: solve it using BT
 */
public class SmallestCommonRegion {
    /*
    - intuition:
        - this is similar to the lca problem, meaning that the lca must have one node in the left branch and the other node in the right branch
        - we could use a hashmap to represent a binary tree
    */
    private String res;
    private boolean found = false;

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, List<String>> tree = new HashMap<>();

        for (List<String> region : regions) {
            String parent = region.get(0);

            List<String> nodes = new ArrayList<>();

            for (int i = 1; i < region.size(); i++) {
                nodes.add(region.get(i));
            }

            tree.put(parent, nodes);
        }

        for (String r : tree.keySet()) {
            if (found) break;
            find(tree, r, region1, region2);
        }

        return res;
    }

    private int find(Map<String, List<String>> tree, String curr, String r1, String r2) {
        if (curr == null) return 0;

        List<String> regions = tree.getOrDefault(curr, new ArrayList<>());

        int total = 0;

        for (String region : regions) {
            total += find(tree, region, r1, r2);
        }

        if (curr.equals(r1) || curr.equals(r2)) {
            total++;
        }

        if (total == 2 && res == null) {
            res = curr;
            found = true;
        }

        return total;
    }
}
