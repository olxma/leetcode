package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Dota2SenateSolutionTest {
    private Dota2SenateSolution solution;

    @BeforeEach
    void setUp() {
        solution = new Dota2SenateSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "D, Dire",
            "RD, Radiant",
            "RDD, Dire",
            "DDRRR, Dire",
            "DRRDRDRDRDDRDRDR, Radiant",
    })
    void predictPartyVictory(String senate, String expected) {
        String result = solution.predictPartyVictory(senate);

        assertEquals(expected, result);
    }
}