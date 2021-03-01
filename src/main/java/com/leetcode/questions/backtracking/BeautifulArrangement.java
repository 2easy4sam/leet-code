package com.leetcode.questions.backtracking;

public class BeautifulArrangement {
    private int cnt;

    public int countArrangement(int N) {
        cnt = 0;

        // 16 because max is 15
        boolean[] nums = new boolean[16];

        for (int num = 1; num <= N; num++) {
            count(nums, num, 1, N);
        }

        return cnt;
    }

    private void count(boolean[] nums, int num, int idx, int N) {
        nums[num] = true;
        if (idx == N) {
            cnt++;
        } else {
            idx++;

            for (int next = 1; next <= N; next++) {
                if (nums[next]) continue;
                if (next % idx == 0 || idx % next == 0) {
                    count(nums, next, idx, N);
                }
            }
        }

        nums[num] = false;
    }
}
