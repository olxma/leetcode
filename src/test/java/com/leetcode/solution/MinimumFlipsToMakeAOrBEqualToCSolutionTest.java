package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumFlipsToMakeAOrBEqualToCSolutionTest {
    private MinimumFlipsToMakeAOrBEqualToCSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumFlipsToMakeAOrBEqualToCSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 6, 5, 3",
            "4, 2, 7, 1",
            "1, 2, 3, 0",
            "8, 3, 5, 3"
    })
    void minFlips(int a, int b, int c, int expected) {
        int result = solution.minFlips(a, b, c);

        assertEquals(expected, result);
    }
}