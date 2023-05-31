package com.leetcode.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DesignUndergroundSystemSolutionTest {

    @Test
    void test() {
        DesignUndergroundSystemSolution undergroundSystem = new DesignUndergroundSystemSolution();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);

        assertEquals(14.0, undergroundSystem.getAverageTime("Paradise", "Cambridge"));
        assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));

        undergroundSystem.checkIn(10, "Leyton", 24);

        assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));

        undergroundSystem.checkOut(10, "Waterloo", 38);

        assertEquals(12.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));
    }

}