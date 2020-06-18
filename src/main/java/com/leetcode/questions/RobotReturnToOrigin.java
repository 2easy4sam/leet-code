package com.leetcode.questions;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int[] coordinates = new int[]{0, 0};

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);

            if (move == 'U') {
                coordinates[1]++;
            } else if (move == 'D') {
                coordinates[1]--;
            } else if (move == 'L') {
                coordinates[0]--;
            } else {
                // right
                coordinates[0]++;
            }
        }

        return coordinates[0] == 0 && coordinates[1] == 0;
    }
}
