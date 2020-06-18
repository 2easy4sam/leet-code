package com.leetcode.questions.graph;

public class LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {
        int nRows = picture.length, nCols = picture[0].length, cnt = 0;
        int[] rowCnt = new int[nRows], colCnt = new int[nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (picture[i][j] == 'B') {
                    rowCnt[i]++;
                    colCnt[j]++;
                    cnt++;
                }
            }
        }

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (picture[i][j] == 'B' && rowCnt[i] > 1 && colCnt[j] > 1)
                    cnt--;
            }
        }

        return cnt;
    }
}
