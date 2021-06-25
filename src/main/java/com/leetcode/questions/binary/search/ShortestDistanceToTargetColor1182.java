package com.leetcode.questions.binary.search;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ShortestDistanceToTargetColor1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> a_indexes = new TreeSet<>();
        TreeSet<Integer> b_indexes = new TreeSet<>();
        TreeSet<Integer> c_indexes = new TreeSet<>();

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 1) {
                a_indexes.add(i);
            } else if (colors[i] == 2) {
                b_indexes.add(i);
            } else {
                c_indexes.add(i);
            }
        }

        for (int[] query : queries) {
            int pos = query[0], c = query[1];

            if (c == 1) {
                getClosest(ans, a_indexes, colors, pos, c);
            } else if (c == 2) {
                getClosest(ans, b_indexes, colors, pos, c);
            } else {
                getClosest(ans, c_indexes, colors, pos, c);
            }
        }

        return ans;
    }

    private void getClosest(List<Integer> ans, TreeSet<Integer> indexes, int[] colors, int pos, int c) {
        if (indexes.isEmpty()) ans.add(-1);
        else if (colors[pos] == c) ans.add(0);
        else {
            Integer l = indexes.lower(pos), r = indexes.higher(pos);

            if (l == null) {
                ans.add(r - pos);
            } else if (r == null) {
                ans.add(pos - l);
            } else {
                // neither is null
                ans.add(Math.min(pos - l, r - pos));
            }
        }
    }
}
