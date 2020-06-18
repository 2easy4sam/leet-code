package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int num = 2; num < n; num++) {
            if (n % num == 0) {
                int f = n / num;
                if (num > f) break;
                List<Integer> combo = new ArrayList<>();
                combo.add(num);
                combo.add(f);
                dfs(result, combo);
            }
        }

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> combo) {
        result.add(combo);
        int secondLast = combo.get(combo.size() - 2);
        int last = combo.get(combo.size() - 1);
        if (last == 2) return;

        for (int num = 2; num < last; num++) {
            if (last % num == 0) {
                int n = last / num;
                if (num > n || n < secondLast || num < secondLast) break;
                List<Integer> tmp = new ArrayList<>(combo.subList(0, combo.size() - 1));
                tmp.add(num);
                tmp.add(n);
                dfs(result, tmp);
            }
        }
    }
}
