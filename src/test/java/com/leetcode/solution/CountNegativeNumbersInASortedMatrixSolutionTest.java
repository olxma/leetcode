package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNegativeNumbersInASortedMatrixSolutionTest {
    private CountNegativeNumbersInASortedMatrixSolution solution;


    @BeforeEach
    void setUp() {
        solution = new CountNegativeNumbersInASortedMatrixSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}, 8),
                Arguments.of(new int[][]{{3, 2}, {1, 0}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void countNegatives(int[][] grid, int expected) {
        int result = solution.countNegatives(grid);

        assertEquals(expected, result);
    }
}