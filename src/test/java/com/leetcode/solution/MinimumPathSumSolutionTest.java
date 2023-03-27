package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumPathSumSolutionTest {
    private MinimumPathSumSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumPathSumSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3,1},{1,5,1},{4,2,1}}, 7),
                Arguments.of(new int[][]{{1,2,3},{4,5,6}}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void minPathSum(int[][] grid, int expected) {
        int result = solution.minPathSum(grid);

        assertEquals(expected, result);
    }
}