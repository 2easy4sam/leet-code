package com.leetcode.questions.array;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and
 * end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number
 * of conference rooms required.
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int nRooms = 0;
        int endTimeIdx = 0;

        for (int i = 0; i < n; i++) {
            if (startTimes[i] < endTimes[endTimeIdx]) nRooms++;
            else endTimeIdx++;
        }

        return nRooms;
    }
}
