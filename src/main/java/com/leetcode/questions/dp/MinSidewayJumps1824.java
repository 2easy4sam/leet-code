package com.leetcode.questions.dp;

import java.util.Arrays;

public class MinSidewayJumps1824 {
    /*
    - keynotes:
        - since the goal is to find the MIN number of side jumps to reach any lane at n, forward movements is always preferred
            - IF canMoveForward()
              THEN moveForward()
    */
    public int minSideJumps(int[] obstacles) {
        int[][] dp = new int[4][obstacles.length];
        for (int[] r : dp) Arrays.fill(r, -1);
        return dfs(obstacles, dp, 0, 2);
    }

    /*
    obstacles, dp, position and lane
    */
    private int dfs(int[] obst, int[][] dp, int p, int lane) {
        // we have already reached the end of a lane
        if (p == obst.length - 1) return 0;
        // if position p at lane is blocked
        if (obst[p] == lane) return Integer.MAX_VALUE;
        if (dp[lane][p] != -1) return dp[lane][p];

        // always move forward if possible as it costs 0
        if (obst[p + 1] != lane) {
            dp[lane][p] = dfs(obst, dp, p + 1, lane);
        } else {
            /*
            - there's a total of 3 lanes
                IF lane - 1 == 0
                THEN lane == 1 AND lane += 2 so that we end up in lane 3
                IF lane + 1 == 4
                THEN lane == 3 AND lane -= 2 so that we end up in lane 1
            */
            int l1 = lane - 1 == 0 ? lane + 2 : lane - 1;
            int l2 = lane + 1 == 4 ? lane - 2 : lane + 1;

            dp[lane][p] = 1 + Math.min(dfs(obst, dp, p, l1), dfs(obst, dp, p, l2));
        }

        return dp[lane][p];
    }
}