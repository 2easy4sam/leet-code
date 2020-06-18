package com.leetcode.questions;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class FlippingAndInvertImageTest {
    private FlippingAndInvertImage flippingAndInvertImage;

    @Before
    public void setUp() {
        flippingAndInvertImage = new FlippingAndInvertImage();
    }

    @Test
    public void test() {
        int[][] A = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        int[][] res = flippingAndInvertImage.flipAndInvertImage(A);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}