package com.leetcode.questions.string;

import java.util.*;

public class LongestAbsoluteFilePath {
    private Map<Integer, List<String>> map;

    public int lengthLongestPath(String input) {
        // depth <-> dir/file names
        map = new HashMap<>();
        map.put(-1, Collections.singletonList("#"));
        Map<String, String> childParentMap = new HashMap<>();

        int i = 0, curr = 0, fileNo = 0;
        StringBuilder sb = new StringBuilder();

        while (i < input.length()) {
            char c = input.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '.' || c == ' ') {
                sb.append(input.charAt(i));
                i++;
            } else if (c == '\n') {
                int tmp = i;

                while (input.charAt(tmp + 1) == '\t') {
                    tmp++;
                }

                int next = tmp - i;
                int prev = curr - 1;

                String fileName = formatFileName(fileNo++, sb.toString());

                if (map.containsKey(prev)) {
                    String parent = map.get(prev).get(map.get(prev).size() - 1);
                    childParentMap.put(fileName, parent);
                }

                map.putIfAbsent(curr, new LinkedList<>());
                map.get(curr).add(fileName);

                sb = new StringBuilder();
                curr = next;
                i = tmp + 1;
            }
        }

        if (map.containsKey(curr - 1)) {
            String parent = map.get(curr - 1).get(map.get(curr - 1).size() - 1);
            childParentMap.put(formatFileName(fileNo, sb.toString()), parent);
        }

        int longest = 0;

        for (Map.Entry<String, String> entry : childParentMap.entrySet()) {
            if (!isFile(entry.getKey())) continue;
            String path = buildPath(childParentMap, entry.getKey(), new StringBuilder());

            if (path.length() > longest) {
                longest = path.length();
            }
        }

        return longest;
    }

    private String formatFileName(int no, String filename) {
        return no + "#" + filename;
    }

    private String buildPath(Map<String, String> map, String curr, StringBuilder sb) {
        String fileName = sanitizeFileName(curr);
        sb.insert(0, fileName).insert(0, "/");
        if (!map.containsKey(curr)) return sb.substring(2);
        return buildPath(map, map.get(curr), sb);
    }

    private String sanitizeFileName(String fileName) {
        return fileName.substring(fileName.indexOf("#") + 1);
    }

    private boolean isFile(String s) {
        return s.contains(".");
    }
}
