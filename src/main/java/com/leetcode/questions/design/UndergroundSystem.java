package com.leetcode.questions.design;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    public static class JourneyInfo {
        double totalDur, times;

        public JourneyInfo() {
            this.totalDur = 0;
            this.times = 0;
        }

        public double avg() {
            return totalDur / times;
        }
    }

    public static class CheckInInfo {
        String station;
        int t;

        public CheckInInfo(String station, int t) {
            this.station = station;
            this.t = t;
        }
    }

    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, Map<String, JourneyInfo>> journeys;

    public UndergroundSystem() {
        // [passengerId, [stationName, check in/out time]]
        checkIns = new HashMap<>();
        // [start, [end, journeyInfo]]
        journeys = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));

        journeys.putIfAbsent(stationName, new HashMap<>());
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = checkIns.get(id).station;

        journeys.get(startStation).putIfAbsent(stationName, new JourneyInfo());
        JourneyInfo ji = journeys.get(startStation).get(stationName);
        ji.totalDur += (t - checkIns.get(id).t);
        ji.times++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        return journeys.get(startStation).get(endStation).avg();
    }
}
