package com.leetcode.questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return dfs(new ArrayList<>(), num);
    }

    private boolean dfs(List<Long> list, String s) {
        if (list.size() >= 2) {
            long sum = list.get(list.size() - 1) + list.get(list.size() - 2);
            int nDigits = countDigits(sum);
            // can't have any leading 0s
            if (nDigits > 1 && s.charAt(0) == '0' || nDigits > s.length()) return false;

            long num = Long.parseLong(s.substring(0, nDigits));

            if (num == sum) {
                list.add(num);
                if (nDigits == s.length()) return true;
                if (dfs(list, s.substring(nDigits))) return true;
                else list.remove(list.size() - 1);
            }
        } else {
            // we haven't yet got 2 digits to add up
            for (int len = 1; len < s.length(); len++) {
                if (len > 1 && s.charAt(0) == '0') continue;
                long num = Long.parseLong(s.substring(0, len));
                list.add(num);
                if (dfs(list, s.substring(len))) return true;
                if (!list.isEmpty()) list.remove(list.size() - 1);
            }
        }

        return false;
    }

    private int countDigits(long num) {
        if (num == 0) return 1;

        int cnt = 0;

        while (num != 0) {
            num /= 10;
            cnt++;
        }

        return cnt;
    }
}
