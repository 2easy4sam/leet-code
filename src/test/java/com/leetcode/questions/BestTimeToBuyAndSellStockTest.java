package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BestTimeToBuyAndSellStockTest {
    private BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock;

    @Before
    public void setUp() {
        bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
    }

    @Test
    public void test_1() {
        int[] stocks = new int[]{7, 1, 5, 3, 6, 4};

        assertThat(bestTimeToBuyAndSellStock.maxProfit(stocks)).isEqualTo(5);
    }

    @Test
    public void test_2() {
        int[] stocks = new int[]{7, 6, 4, 3, 1};

        assertThat(bestTimeToBuyAndSellStock.maxProfit(stocks)).isEqualTo(0);
    }

    @Test
    public void test_3() {
        int[] stocks = new int[]{2, 4, 1};

        assertThat(bestTimeToBuyAndSellStock.maxProfit(stocks)).isEqualTo(2);
    }

    @Test
    public void test_4() {
        int[] stocks = new int[]{};

        assertThat(bestTimeToBuyAndSellStock.maxProfit(stocks)).isEqualTo(0);
    }

    @Test
    public void test_5() {
        int[] stocks = new int[]{3, 2, 6, 5, 0, 3};

        assertThat(bestTimeToBuyAndSellStock.maxProfit(stocks)).isEqualTo(4);
    }
}