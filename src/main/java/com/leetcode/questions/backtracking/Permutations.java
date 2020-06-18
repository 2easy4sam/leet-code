package com.leetcode.questions.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        Set<List<Integer>> set = new HashSet<>();
        Queue<Combo> q = new LinkedList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            List<Integer> combo = new ArrayList<>();
            combo.add(nums[i]);
            List<Integer> newNums = new ArrayList<>();
            newNums.addAll(arrToList(Arrays.copyOfRange(nums, 0, i)));
            newNums.addAll(arrToList(Arrays.copyOfRange(nums, i + 1, n)));

            q.offer(new Combo(combo, newNums));
        }

        while (!q.isEmpty()) {
            final int size = q.size();

            for (int i = 0; i < size; i++) {
                Combo top = q.poll();

                for (int j = 0; j < top.nums.size(); j++) {
                    List<Integer> combo = new ArrayList<>(top.combo);
                    combo.add(top.nums.get(j));

                    if (combo.size() == n) {
                        set.add(combo);
                    } else {
                        List<Integer> newNums = new ArrayList<>();
                        newNums.addAll(top.nums.subList(0, j));
                        newNums.addAll(top.nums.subList(j + 1, top.nums.size()));
                        q.offer(new Combo(combo, newNums));
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    private List<Integer> arrToList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static class Combo {
        List<Integer> combo;
        List<Integer> nums;

        Combo(List<Integer> combo, List<Integer> nums) {
            this.combo = combo;
            this.nums = nums;
        }
    }
}
