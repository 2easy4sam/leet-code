package com.leetcode.questions.design;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {
    private static class MyCalendar {
        private List<int[]> events;

        public MyCalendar() {
            events = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] event : events) {
                if (Math.max(start, event[0]) < Math.min(end, event[1])) return false;
            }

            events.add(new int[]{start, end});
            return true;
        }
    }

    /*
    - it differs from MyCalendarI in the sense that overlapping once is fine, but twice or more is not acceptable
    */
    private List<int[]> events;

    public MyCalendarII() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        MyCalendar myCalendar = new MyCalendar();

        for (int[] event : events) {
            if (Math.max(start, event[0]) < Math.min(end, event[1])) {
                if (!myCalendar.book(Math.max(start, event[0]), Math.min(end, event[1]))) return false;
            }
        }

        events.add(new int[]{start, end});

        return true;
    }
}
