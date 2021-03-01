package com.leetcode.questions.dfs;

import java.util.*;

public class ReconstructItinerary {
    /*
    - intuition:
        - an itinerary is said to be complete IF and only IF it consists of all of the cities which names appear on the given list of airline tickets, be it a start city or a dest city. Thus, we need to know the total number of cities, denote it n
    */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> journeys = new HashMap<>();

        for (List<String> ticket : tickets) {
            journeys.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            journeys.get(ticket.get(0)).add(ticket.get(1));
        }
        LinkedList<String> itinerary = new LinkedList<>();
        dfs(itinerary, journeys, "JFK");
        return itinerary;
    }

    private void dfs(LinkedList<String> itinerary, Map<String, PriorityQueue<String>> journeys, String from) {
        PriorityQueue<String> tos = journeys.get(from);

        while (tos != null && !tos.isEmpty()) {
            dfs(itinerary, journeys, tos.poll());
        }

        itinerary.addFirst(from);
    }
}
