package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsSolutionTest {
    private ClimbingStairsSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ClimbingStairsSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2; 2",
            "3; 3",
            "4; 5",
            "5; 8"
    }, delimiter = ';')
    void climbStairs(int n, int expected) {
        int result = solution.climbStairs(n);

        assertEquals(expected, result);
    }
}