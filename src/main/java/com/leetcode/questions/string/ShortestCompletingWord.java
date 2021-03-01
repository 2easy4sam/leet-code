package com.leetcode.questions.string;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = null;

        licensePlate = licensePlate.toLowerCase();
        int[] cnt = count(licensePlate);

        for (String word : words) {
            int[] charCnt = count(word);

            boolean valid = true;
            for (int i = 0; i < 26 && valid; i++) {
                if (cnt[i] == 0) continue;
                if (cnt[i] > charCnt[i]) {
                    valid = false;
                }
            }

            if (res == null || valid && word.length() < res.length()) {
                res = word;
            }
        }

        return res;
    }

    private int[] count(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int isLower = c - 'a';
            if (isLower >= 0 && isLower < 26) cnt[isLower]++;
        }

        return cnt;
    }
}
