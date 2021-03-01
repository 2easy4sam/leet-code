package com.leetcode.questions.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatchsticksToSquare {


    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        Arrays.sort(nums);

        int len, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            sum += num;
        }

        if ((double) sum / 4 != (len = sum / 4)) return false;
        return dfs(map, 0, len, 0);
    }

    private boolean dfs(Map<Integer, Integer> map, int curr, int len, int nEdges) {
        if (nEdges == 4) return true;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();

            if (cnt == 0) continue;
            if (curr == len) {
                /*
                no need to link any more
                */
                map.put(num, cnt - 1);
                if (dfs(map, 0, len, nEdges + 1)) return true;
                map.put(num, cnt);
            } else {
                int newLen = curr + num;
                if (newLen > len) break;
                else if (newLen == len) {
                    map.put(num, cnt - 1);
                    if (dfs(map, 0, len, nEdges + 1)) return true;
                    map.put(num, cnt);
                } else {
                    map.put(num, cnt - 1);
                    if (dfs(map, newLen, len, nEdges)) return true;
                    map.put(num, cnt);
                }
            }
        }

        return false;
    }
}
