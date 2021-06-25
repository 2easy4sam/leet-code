package com.leetcode.questions.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    /*
    - need a function to map int -> coords and vice versa
    */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        for (int moves = 0; !q.isEmpty(); moves++) {
            for (int size = q.size(); size > 0; size--) {
                int curr = q.poll();
                if (visited[curr]) continue;
                visited[curr] = true;
                if (curr == n * n) return moves;

                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    int val = getBoardValue(board, next);
                    if (val > 0) next = val;
                    if (!visited[next]) q.offer(next);
                }
            }
        }

        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int c = (num - 1) % n;
        int y = r % 2 == 0 ? c : n - 1 - c;

        return board[x][y];
    }
}
