package com.leetcode.questions.dfs;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReconstructItineraryTest {
    private ReconstructItinerary reconstructItinerary;

    @Before
    public void setUp() {
        reconstructItinerary = new ReconstructItinerary();
    }

    @Test
    public void test_1() {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );

        assertThat(reconstructItinerary.findItinerary(tickets))
                .containsExactly("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
    }

    @Test
    public void test_2() {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "KUL"),
                Arrays.asList("JFK", "NRT"),
                Arrays.asList("NRT", "JFK")
        );

        assertThat(reconstructItinerary.findItinerary(tickets))
                .containsExactly("JFK", "NRT", "JFK", "KUL");
    }

    @Test
    public void test_3() {
    }
}