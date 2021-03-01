package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BombEnemyTest {
    private BombEnemy bombEnemy;

    @Before
    public void setUp() {
        bombEnemy = new BombEnemy();
    }

    @Test
    public void test_1() {
        char[][] grid = new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };

        assertThat(bombEnemy.maxKilledEnemies(grid)).isEqualTo(3);
    }
}