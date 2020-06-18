package com.leetcode.questions.graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LonelyPixelITest {
    private LonelyPixelI lonelyPixelI;

    @Before
    public void setUp() {
        lonelyPixelI = new LonelyPixelI();
    }

    @Test
    public void test_1() {
        char[][] picture = new char[][]{
                {'B', 'W', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'W'}
        };

        assertThat(lonelyPixelI.findLonelyPixel(picture)).isEqualTo(1);
    }
}