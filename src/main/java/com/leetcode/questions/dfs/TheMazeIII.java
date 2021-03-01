package com.leetcode.questions.dfs;

import java.util.PriorityQueue;

public class TheMazeIII {
    private static class Cell {
        int x, y, dist;
        String path;

        public Cell(int x, int y, int dist, String path) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = path;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        char[] dirChars = new char[]{'u', 'd', 'l', 'r'};

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            return a.path.compareTo(b.path);
        });
        pq.offer(new Cell(ball[0], ball[1], 0, ""));

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();

            if (curr.x == hole[0] && curr.y == hole[1]) return curr.path;

            if (!visited[curr.x][curr.y]) {
                visited[curr.x][curr.y] = true;

                for (int i = 0; i < 4; i++) {
                    Cell next = roll(maze, curr, dirs[i], hole);
                    pq.offer(new Cell(next.x, next.y, next.dist, next.path + dirChars[i]));
                }
            }
        }

        return "impossible";
    }

    private Cell roll(int[][] maze, Cell curr, int[] dir, int[] hole) {
        int x = curr.x, y = curr.y, dist = curr.dist;

        while (canRoll(maze, x + dir[0], y + dir[1])) {
            x += dir[0];
            y += dir[1];
            dist++;

            if (x == hole[0] && y == hole[1]) {
                return new Cell(x, y, dist, curr.path);
            }
        }

        return new Cell(x, y, dist, curr.path);
    }

    private boolean canRoll(int[][] maze, int x, int y) {
        if (x < 0 || x == maze.length || y < 0 || y == maze[0].length) return false;
        return maze[x][y] != 1;
    }
}
