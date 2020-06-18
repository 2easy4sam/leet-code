package com.leetcode.questions.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: solve it using BT
 */
public class SmallestCommonRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        // this problem can be interpreted as:
        // 1. tree problem
        // 2. union find problem

        DisjointSet ds = new DisjointSet();

        int r1 = regions.size() - 1;
        int r2 = regions.size() - 1;

        // init
        for (int i = 0; i < regions.size(); i++) {
            for (String r : regions.get(i)) {
                ds.makeSet(r);
                if (r.equals(region1)) r1 = Math.min(r1, i);
                else if (r.equals(region2)) r2 = Math.min(r2, i);
            }
        }

        // 1 level up
        int i = r1 == r2 ? r1 : Math.max(0, Math.min(r1, r2) - 1);
        while (i < regions.size()) {
            List<String> region = regions.get(i);
            for (int j = 0; j < region.size() - 1; j++) {
                ds.union(region.get(j), region.get(j + 1));
            }
            String rep1 = ds.find(region1).parent.data;
            String rep2 = ds.find(region2).parent.data;

            if (rep1.equals(rep2)) return rep2;
            i++;
        }

        return null;
    }

    private static class DisjointSet {
        class Node {
            public Node parent;    // representative of the set
            public String data;
            public int rank;

            public Node(String data) {
                this.data = data;
                rank = 0;
            }
        }

        private Map<String, Node> map;

        DisjointSet() {
            map = new HashMap<>();
        }

        // makeSet
        private void makeSet(String data) {
            Node node = new Node(data);
            node.parent = node;
            map.put(data, node);
        }

        // union
        private boolean union(String d1, String d2) {
            Node rep1 = find(d1);
            Node rep2 = find(d2);

            if (rep1 == rep2) return false;

            if (rep1.rank >= rep2.rank) {
                rep2.parent = rep1;
                if (rep1.rank == rep2.rank) rep1.rank++;
            } else {
                rep1.parent = rep2;
            }

            return true;
        }

        // finds the representative of the group
        private Node find(String data) {
            Node node = map.get(data);

            if (node == node.parent) return node;

            node.parent = find(node.parent.data);
            return node.parent;
        }
    }
}
