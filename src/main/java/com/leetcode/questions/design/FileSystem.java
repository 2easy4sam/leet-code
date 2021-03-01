package com.leetcode.questions.design;

import java.util.HashMap;
import java.util.Map;

class FileSystem {

    Map<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (map.containsKey(path)) return false;
        int prev = -1, i = 0;

        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                if (prev != -1) {
                    if (!map.containsKey(path.substring(0, i))) return false;
                }

                prev = i;
            }

            i++;
        }

        map.put(path, value);

        return true;
    }

    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}