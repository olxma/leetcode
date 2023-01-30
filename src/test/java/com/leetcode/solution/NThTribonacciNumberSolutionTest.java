package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NThTribonacciNumberSolutionTest {
    private static NThTribonacciNumberSolution solution;

    @BeforeEach
    void setUp() {
        solution = new NThTribonacciNumberSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4,     4",
            "25,    1389537"
    })
    void tribonacci(int n, int expected) {
        int result = solution.tribonacci(n);

        assertEquals(expected, result);
    }
}