package com.leetcode.learn.queue;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WallsAndGatesTest {
    private static final int EMPTY_ROOM = Integer.MAX_VALUE;
    private static final int WALL = -1;
    private static final int GATE = 0;

    private WallsAndGates wallsAndGates;

    @Before
    public void setUp() {
        wallsAndGates = new WallsAndGates();
    }

    @Test
    public void test() {
        int[][] rooms = new int[][]{
                {EMPTY_ROOM, WALL, GATE, EMPTY_ROOM},
                {EMPTY_ROOM, EMPTY_ROOM, EMPTY_ROOM, WALL},
                {EMPTY_ROOM, WALL, EMPTY_ROOM, WALL},
                {GATE, WALL, EMPTY_ROOM, EMPTY_ROOM}
        };

        int[][] expected = new int[][]{
                {3, WALL, GATE, 1},
                {2, 2, 1, WALL},
                {1, WALL, 2, WALL},
                {GATE, WALL, 3, 4}
        };

        wallsAndGates.wallsAndGates(rooms);

        assertThat(rooms).containsExactly(expected);
    }
}