package com.leetcode.questions.graph;

import java.util.Arrays;

public class ConnectingCitiesWithMinCost {

    public int minimumCost(int N, int[][] connections) {
        int[] parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
        int cnt = N, sum = 0;
        Arrays.sort(connections, (conn1, conn2) -> conn1[2] - conn2[2]);
        for (int[] conn : connections) {
            int p1 = find(parents, conn[0]);
            int p2 = find(parents, conn[1]);

            if (p1 != p2) {
                sum += conn[2];
                parents[p1] = p2;
                cnt--;
            }
        }

        if (cnt != 1) return -1;

        return sum;
    }

    private int find(int[] parents, int i) {
        if (parents[i] == i) return i;
        return parents[i] = find(parents, parents[i]);
    }
}
