package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPathInBinaryMatrixSolutionTest {
    private ShortestPathInBinaryMatrixSolution solution;

    @BeforeEach
    void setUp() {
        solution = new ShortestPathInBinaryMatrixSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1}, {1, 0}}, 2),
                Arguments.of(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}, 4),
                Arguments.of(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void shortestPathBinaryMatrix(int[][] grid, int expected) {
        int result = solution.shortestPathBinaryMatrix(grid);

        assertEquals(expected, result);
    }
}