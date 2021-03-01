package com.leetcode.questions.dp;

import java.util.LinkedHashMap;
import java.util.Map;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        /*
        - test cases:
        - constraints/key words:
        - thinking out loud:
            - suppose we have
                day     cost
                1       2
                7       7
                30      15

                to make a 30-day pass worthwhile, there needs to be at least 7 + 5 days (7 + 10 = 17 > 15) between the start day and end day (inclusive)
                e.g. [1,2,3,4,5,6,7,8]
                because if we bought a 30-day pass on day 1
                it would cost 15
                whereas if we bought a 7-day pass, it would cost
                7, and cover the period day 1 - day 7
                then we need to buy another day-pass on day 8
                total = 7 + 2 = 9 < 15
        - time and space complexity:
        */

        int weeklyPassThreshold = costs[1] / costs[0];
        int monthlyPassThreshold = (costs[2] - costs[1]) / costs[0] + 7;
        Map<Integer, int[]> map = new LinkedHashMap<>();
        map.put(30, new int[]{monthlyPassThreshold, costs[2]});
        map.put(7, new int[]{weeklyPassThreshold, costs[1]});
        map.put(1, new int[]{0, costs[0]});

        int i = 0;
        int cost = 0;

        while (i < days.length) {
            int start = days[i];

            for (int len : map.keySet()) {
                int end = start + len - 1;
                int threshold = map.get(len)[0];
                int c = map.get(len)[1];
                int j = i, cnt = 0;

                while (j < days.length && days[j] <= end) {
                    j++;
                    cnt++;
                }

                if (cnt > threshold) {
                    i = j;
                    cost += c;
                    break;
                }
            }
        }

        return cost;
    }
}
