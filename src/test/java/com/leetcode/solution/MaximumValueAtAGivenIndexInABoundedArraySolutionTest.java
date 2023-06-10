package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumValueAtAGivenIndexInABoundedArraySolutionTest {
    private MaximumValueAtAGivenIndexInABoundedArraySolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumValueAtAGivenIndexInABoundedArraySolution();
    }

    @ParameterizedTest
    @CsvSource({
            "4, 2, 6, 2",
            "6, 1, 10, 3",
            "9, 3, 16, 3"
    })
    void maxValue(int n, int index, int maxSum, int expected) {
        int result = solution.maxValue(n, index, maxSum);

        assertEquals(expected, result);
    }
}