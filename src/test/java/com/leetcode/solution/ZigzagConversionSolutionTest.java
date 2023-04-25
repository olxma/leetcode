package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagConversionSolutionTest {
    private ZigzagConversionSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ZigzagConversionSolution();
    }

    @ParameterizedTest
    @CsvSource({
            "PAYPALISHIRING, 3, PAHNAPLSIIGYIR",
            "PAYPALISHIRING, 4, PINALSIGYAHRPI",
            "A, 1, A",
            "AB, 1, AB"
    })
    void convert(String s, int numRows, String expected) {
        String result = solution.convert(s, numRows);

        assertEquals(expected, result);
    }
}