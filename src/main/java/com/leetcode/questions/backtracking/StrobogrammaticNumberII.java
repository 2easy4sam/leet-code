package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('0', '0');
        pairs.put('1', '1');
        pairs.put('6', '9');
        pairs.put('8', '8');
        pairs.put('9', '6');

        char[] arr = new char[n];

        List<String> output = new ArrayList<>();

        int mid = n / 2;

        dfs(pairs, output, arr, n % 2 == 0 ? mid - 1 : mid, mid, n);

        return output;
    }

    private void dfs(Map<Character, Character> pairs, List<String> list, char[] arr, int i, int j, int n) {
        for (char key : pairs.keySet()) {
            if (i == j && (key == '6' || key == '9')) continue;
            if (j - i + 1 == n && key == '0') continue;
            arr[i] = key;
            arr[j] = pairs.get(key);

            if (j - i + 1 == n) {
                list.add(new String(arr));
            } else {
                dfs(pairs, list, arr, i - 1, j + 1, n);
            }
        }
    }
}
