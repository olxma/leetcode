package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DominoAndTrominoTilingSolutionTest {
    private DominoAndTrominoTilingSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DominoAndTrominoTilingSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 1",
            "2, 2",
            "3, 5",
            "4, 11",
            "5, 24",
            "6, 53",
            "7, 117",
            "8, 258",
            "30, 312342182",
            "60, 882347204"
    })
    void numTilings(int n, int expected) {
        int result = solution.numTilings(n);

        assertEquals(expected, result);
    }
}