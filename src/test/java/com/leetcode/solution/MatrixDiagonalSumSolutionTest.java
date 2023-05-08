package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixDiagonalSumSolutionTest {
    private MatrixDiagonalSumSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MatrixDiagonalSumSolution();
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, 25),
                Arguments.of(new int[][]{
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}
                }, 8),
                Arguments.of(new int[][]{{5}}, 5));
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void diagonalSum(int[][] mat, int expected) {
        int result = solution.diagonalSum(mat);

        assertEquals(expected, result);
    }
}