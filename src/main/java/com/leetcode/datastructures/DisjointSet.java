package com.leetcode.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * In the beginning, all data sets contain a single element, in other
 * words each element is in its own right a set.
 * <p>
 * All nodes initially have a rank of 0. When two nodes at the same
 * rank are merged, either can be the parent of the other. Whichever
 * becomes the parent will have its rank incremented by 1.
 * <p>
 * Each set has a representative, which is always the highest-ranked
 * element, and the representative will always point to itself.
 */
public class DisjointSet {
    class Node {
        int rank;   // defaults to 0
        Node parent;
        long data;

        Node(long data) {
            this.data = data;
            this.rank = 0;
        }
    }

    private Map<Long, Node> map;

    public DisjointSet() {
        map = new HashMap<>();
    }

    public Node makeSet(long data) {
        Node node = new Node(data);
        node.parent = node;
        map.put(data, node);
        return node;
    }

    /**
     * Find the representative of the set that {@param data} belongs
     * to. We know a representative is found when the its parent is
     * itself.
     */
    public Node find(long data) {
        Node node = map.get(data);

        if (node.parent == node) {
            return node;
        }

        // path compression
        node.parent = find(node.parent.data);

        return node.parent;
    }

    public boolean union(long d1, long d2) {

        Node rep1 = find(d1);
        Node rep2 = find(d2);

        if (rep1.data == rep2.data) return false;

        if (rep1.rank >= rep2.rank) {
            rep2.parent = rep1;
            if (rep1.rank == rep2.rank) {
                rep1.rank++;
            }
        } else {
            rep1.parent = rep2;
        }

        return true;
    }
}
