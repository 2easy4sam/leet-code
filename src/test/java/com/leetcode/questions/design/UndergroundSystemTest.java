package com.leetcode.questions.design;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UndergroundSystemTest {
    private UndergroundSystem undergroundSystem;

    @Before
    public void setUp() {
        undergroundSystem = new UndergroundSystem();
    }

    @Test
    public void test_1() {
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        assertThat(undergroundSystem.getAverageTime("Leyton", "Paradise")).isEqualTo(5.0);
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        assertThat(undergroundSystem.getAverageTime("Leyton", "Paradise")).isEqualTo(5.5);
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        assertThat(undergroundSystem.getAverageTime("Leyton", "Paradise")).isEqualTo(6.66667);
    }
}