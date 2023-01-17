package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlipStringToMonotoneIncreasingSolutionTest {
    private FlipStringToMonotoneIncreasingSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FlipStringToMonotoneIncreasingSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "00110;     1",
            "010110;    2",
            "00011000;  2"
    }, delimiter = ';')
    void minFlipsMonoIncr(String s, int expected) {
        int result = solution.minFlipsMonoIncr(s);

        assertEquals(expected, result);
    }
}