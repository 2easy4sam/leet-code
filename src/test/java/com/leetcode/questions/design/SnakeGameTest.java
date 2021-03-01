package com.leetcode.questions.design;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SnakeGameTest {
    @Test
    public void test_1() {
        int[][] food = new int[][]{
                {1, 2},
                {0, 1}
        };

        SnakeGame snakeGame = new SnakeGame(3, 2, food);

        assertThat(snakeGame.move("R")).isEqualTo(0);
        assertThat(snakeGame.move("D")).isEqualTo(0);
        assertThat(snakeGame.move("R")).isEqualTo(1);
        assertThat(snakeGame.move("U")).isEqualTo(1);
        assertThat(snakeGame.move("L")).isEqualTo(2);
        assertThat(snakeGame.move("D")).isEqualTo(2);
    }

    @Test
    public void test_2() {
        int[][] food = new int[][]{
                {1, 0},
                {0, 1},
                {1, 2},
                {0, 3},
                {1, 4},
                {0, 4}
        };

        SnakeGame snakeGame = new SnakeGame(5, 2, food);

        assertThat(snakeGame.move("D")).isEqualTo(1);
        assertThat(snakeGame.move("R")).isEqualTo(1);
        assertThat(snakeGame.move("U")).isEqualTo(2);
        assertThat(snakeGame.move("R")).isEqualTo(2);
        assertThat(snakeGame.move("D")).isEqualTo(3);
        assertThat(snakeGame.move("R")).isEqualTo(3);
        assertThat(snakeGame.move("U")).isEqualTo(4);
        assertThat(snakeGame.move("R")).isEqualTo(4);
        assertThat(snakeGame.move("D")).isEqualTo(5);
        assertThat(snakeGame.move("L")).isEqualTo(-1);
    }
}