package com.leetcode.questions.graph;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> output = new ArrayList<>();

        DisjointSet ds = new DisjointSet();

        for (List<String> account : accounts) {
            // initialize disjoint set
            for (int i = 1; i < account.size(); i++) {
                ds.makeSet(account.get(i), account.get(0));
            }
        }

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size() - 1; i++) {
                ds.union(account.get(i), account.get(i + 1));
            }
        }

        Map<DisjointSet.Node, Set<String>> groups = new HashMap<>();

        for (String email : ds.map.keySet()) {
            DisjointSet.Node rep = ds.find(email);
            Set<String> group = groups.getOrDefault(rep, new TreeSet<>());
            group.add(email);
            groups.put(rep, group);
        }

        for (DisjointSet.Node rep : groups.keySet()) {
            List<String> group = new ArrayList<>(groups.get(rep));
            group.add(0, rep.name);
            output.add(group);
        }

        return output;
    }

    class DisjointSet {
        class Node {
            int rank;
            Node rep;
            String email;
            String name;

            public Node(String email, String name) {
                this.email = email;
                this.name = name;
                this.rank = 1;
            }

            @Override
            public int hashCode() {
                return Objects.hash(email, name);
            }
        }

        Map<String, Node> map;

        public DisjointSet() {
            this.map = new HashMap<>();
        }

        // makeSet
        public void makeSet(String email, String name) {
            Node node = new Node(email, name);
            node.rep = node;
            map.put(email, node);
        }

        // find representative of the set
        public Node find(String email) {
            Node node = map.get(email);

            if (node.rep == node) {
                return node;
            }

            // path compression
            node.rep = find(node.rep.email);
            return node.rep;
        }

        // union
        public boolean union(String email1, String email2) {
            Node rep1 = find(email1);
            Node rep2 = find(email2);

            // union didn't take place
            if (rep1 == rep2) return false;

            if (rep1.rank >= rep2.rank) {
                if (rep1.rank == rep2.rank) {
                    rep1.rank++;
                }

                rep2.rep = rep1;
            } else {
                rep1.rep = rep2;
            }

            return true;
        }
    }
}
