package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrixSolutionTest {
    private SpiralMatrixSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SpiralMatrixSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                Arguments.of(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }, List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
                Arguments.of(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                }, List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void spiralOrder(int[][] matrix, List<Integer> expected) {
        List<Integer> result = solution.spiralOrder(matrix);

        assertEquals(expected, result);
    }
}