package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> output = new ArrayList<>();
        int[] dotIndexes = new int[3];

        dfs(output, dotIndexes, s, 0, 1, 1);

        return output;
    }

    private void dfs(List<String> output, int[] dotIndexes, String s, int begin, int len, int nParts) {
        if (nParts > 4) return;

        while (len <= 3 && begin + len < s.length()) {
            int end = begin + len;
            int num = Integer.parseInt(s.substring(begin, end));

            if (num > 255 || (len > 1 && s.charAt(begin) == '0')) break;

            if (nParts < 4) dotIndexes[nParts - 1] = end;
            // within range [0,255]
            if (end == s.length() - 1) {
                StringBuilder sb = new StringBuilder()
                        .append(s, 0, dotIndexes[0])
                        .append(".")
                        .append(s, dotIndexes[0], dotIndexes[1])
                        .append(".")
                        .append(s, dotIndexes[1], dotIndexes[2])
                        .append(".")
                        .append(s.substring(dotIndexes[2]));

                output.add(sb.toString());
            } else {
                dfs(output, dotIndexes, s, end, 1, nParts + 1);
            }

            len++;
        }
    }
}
