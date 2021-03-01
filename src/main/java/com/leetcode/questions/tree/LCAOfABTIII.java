package com.leetcode.questions.tree;

import com.leetcode.datastructures.DLNode;

import java.util.LinkedHashSet;
import java.util.Set;

public class LCAOfABTIII {
    /*
    - intuition:
        - one node can be the lca of the other node, i.e. p is the lca of q, q is the lca of p
        - use a hash set to record values
            - traverse up first (in both tree), whichever node they come across that both have in common first, is the lca
    */
    public DLNode lowestCommonAncestor(DLNode p, DLNode q) {
        Set<DLNode> set = new LinkedHashSet<>();

        while (p != null || q != null) {
            if (!set.add(p)) return p;
            if (!set.add(q)) return q;
            if (p != null) p = p.parent;
            if (q != null) q = q.parent;
        }

        return null;
    }
}
