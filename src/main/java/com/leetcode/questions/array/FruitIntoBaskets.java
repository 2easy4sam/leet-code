package com.leetcode.questions.array;

import java.util.HashSet;
import java.util.Set;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        Set<Integer> set = new HashSet<>();

        int i = 0, j, max = 0, n = tree.length;

        for (j = 0; j < n; j++) {
            set.add(tree[j]);

            while (set.size() > 2) {
                set.remove(tree[i++]);
                set.add(tree[i]);
            }

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
