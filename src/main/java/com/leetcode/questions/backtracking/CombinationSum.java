package com.leetcode.questions.backtracking;

import java.util.*;

public class CombinationSum {

    private Set<List<Integer>> set;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return Collections.emptyList();
        // sort the array
        Arrays.sort(candidates);
        set = new HashSet<>();

        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate > target) break;
            List<Integer> list = new ArrayList<>();
            list.add(candidate);
            dfs(list, candidates, i, target);
        }

        return new ArrayList<>(set);
    }

    private void dfs(List<Integer> list, int[] candidates, int i, int target) {
        if (i > candidates.length - 1) return;
        int candidate = candidates[i];
        int sum = sum(list);
        if (sum == target) {
            set.add(list);
            return;
        } else if (sum > target) return;

        int diff = target - sum;
        int n = diff / candidate;

        if (candidate > diff) return;

        List<Integer> copy = new ArrayList<>(list);

        for (int j = 0; j < n; j++) {
            dfs(new ArrayList<>(copy), candidates, i, target);
            dfs(new ArrayList<>(copy), candidates, i + 1, target);
            copy.add(candidate);
        }
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) sum += num;
        return sum;
    }
}
