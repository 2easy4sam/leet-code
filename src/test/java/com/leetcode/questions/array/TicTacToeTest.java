package com.leetcode.questions.array;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeTest {
    private TicTacToe ticTacToe;

    @Test
    public void test_1() {
        ticTacToe = new TicTacToe(2);
        ticTacToe.move(0, 1, 1);
        ticTacToe.move(1, 1, 2);
        assertThat(ticTacToe.move(1, 0, 1)).isEqualTo(1);
    }


}